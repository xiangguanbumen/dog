package com.ncell.wangcai.service.cns.main.physiology.pojo.impl;

import com.ncell.wangcai.pojo.cns.main.Cell;
import com.ncell.wangcai.pojo.cns.main.runtime.RunningMessageCenter;
import com.ncell.wangcai.pojo.cns.main.runtime.RunningPojoCenter;
import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import com.ncell.wangcai.pojo.cns.main.warehouse.Warehouse;
import com.ncell.wangcai.service.cns.main.physiology.pojo.PojoCreatService;
import com.ncell.wangcai.utils.cns.main.CellUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 创造新的pojo，这是最难的部分。
 * 到运行时中去找激活的pojo，没有目的地的消息
 * 组合成为新的pojo，这个pojo比组成他的最高的pojo高一级。
 *
 * @author anliwei
 * @Date 2020/6/11 20:35
 * @update 2020-6-15 20:36:29
 */
@Service("pojoCreatServiceImpl")
@Data
@AllArgsConstructor
public class PojoCreatServiceImpl implements PojoCreatService {

    Warehouse warehouse;
    CellWarehouse cellWarehouse;
    RunningMessageCenter runningMessageCenter;
    RunningPojoCenter runningPojoCenter;
    PojoGroupServiceImpl pojoGroupService;
    CellUtil cellUtil;


    /**
     * 总的方法
     */
    @Override
    public void doCreatService() {

        this.creatPojoByPojo();
    }

    /**
     * 通过消息生产pojo
     * 将生成的pojo放到对应的仓库中
     */
    @Override
    public void creatPojoByMessage() {

    }

    /**
     * 通过已经兴奋的pojo生产pojo
     * 将生成的pojo放到对应的仓库中
     */
    @Override
    public void creatPojoByPojo() {

        /**
         * 细胞的生成方法又很多种，这里暂时只使用时间差导数分割法
         */

        createCellMethodOne();

    }

    /**
     * 时间差导数分割法
     * (这里先使用固定阈值法)
     */

    void createCellMethodOne() {

        /**
         * 生成细胞的过程中的不同方法使用的不同队列
         * m代表方法变化
         * s代表步骤变化
         * 比如m1s1就是生成细胞的第一种方法的第一个步骤产生的结果
         *
         * s0表示的是对队列的复制，
         * m1s0 表示方法m1所需要的原始队列的复制队列
         */

        //ConcurrentLinkedQueue<String>  m1s0 = new ConcurrentLinkedQueue<String>();

        // ConcurrentLinkedQueue<Long>  m1s1 = new ConcurrentLinkedQueue<Long>();

        //ConcurrentLinkedQueue<String>  m1s2 = new ConcurrentLinkedQueue<String>();

        // ConcurrentLinkedQueue<String>  m1s3 = new ConcurrentLinkedQueue<String>();

        ArrayList<String> m1s00 = new ArrayList<String>();
        ArrayList<Cell> m1s0 = new ArrayList<Cell>();
        ArrayList<Long> m1s1 = new ArrayList<Long>();
        ArrayList<Long> m1s2 = new ArrayList<Long>();
       // ArrayList<String> m1s3 = new ArrayList<String>();


        /**
         * 第负一步复制队列
         */
        for (String string : cellWarehouse.getExcitedCellQueueForGenerateNewCell()) {
            System.out.println(string);
            m1s00.add(string);
        }

        /**
         * 第零步将细胞名称转换成细胞实例
         */

        for (String string : cellWarehouse.getExcitedCellQueueForGenerateNewCell()) {
            System.out.println(string);
            m1s0.add(cellWarehouse.getAllCell().get(string));
        }

        /**
         * 第一步找到兴奋时间
         *
         */
        for (Cell cell : m1s0) {
            Long excitedTime = cell.getCurrentStateStartTime();
            System.out.println(excitedTime);
            m1s1.add(excitedTime);
        }


        /**
         * 第二步计算时间间隔
         *
         * tn（第二组）=tn（上一组）-t（n+1）（上一组）
         */
        for (int i = 0; i < m1s1.size() - 1; i++) {

            Long excitedTimeOne = m1s1.get(i);
            Long excitedTimeTwo = m1s1.get(i + 1);
            Long timeSpan = excitedTimeTwo - excitedTimeOne;
            System.out.println(timeSpan);
            m1s2.add(timeSpan);
        }

        /**
         * 第三步标记拐点细胞
         * 时间间隔阈值设置为1000毫秒，大于1000则切割
         * 将切割点两端的细胞分别标记为拐点细胞
         * 拐点稀细胞名称后面加上一个“#”
         */
        for (int i = 0; i < m1s2.size(); i++
        ) {

            //如果阈值大于1000，分割点两端的细胞均标记为拐点细胞
            if (m1s2.get(i) > 1000) {
                 m1s00.set(i,m1s0.get(i).getName()+"#");
                 m1s00.set(i+1,m1s0.get(i+1).getName()+"#");
            }
            //如果阈值小于1000，直接存储细胞名称
            else{
               // m1s00.set(i,m1s0.get(i).getName());

            }

        }

        //首个细胞标记为拐点细胞
        m1s00.set(0,m1s0.get(0).getName()+"#");
        //最后一个细胞标记为拐点细胞
        m1s00.set(m1s00.size()-1,m1s0.get(m1s00.size()-1).getName()+"#");


        /**
         * 第三步根据拐点细胞分组并生成新的细胞
         *
         */
        //用于存储分割好的细胞名称队列
        LinkedList linkedList=new LinkedList();
        //标识符
        boolean start =false;
        boolean end =false;

        for(int i = 0; i < m1s00.size(); i++) {

            //如果开始标识符为false
            if(start ==false){
                //如果细胞名称包含拐点标记，表示新的存储开始
                if(m1s00.get(i).contains("#"))
                {start=true;
                linkedList.add(m1s00.get(i).replace("#",""));}
                else{
                    linkedList.add(m1s00.get(i));
                }
            }
            //如果开始标记符号为true
            else{
                //如果细胞名称包含拐点标记，表示存储结束
                if(m1s00.get(i).contains("#")){
                    linkedList.add(m1s00.get(i).replace("#",""));

                    //生成新的细胞，关键步骤
                    cellUtil.creatCellByNameList(linkedList);

                    //标记符复位
                    start =false;
                    end =false;
                }
                else{
                    linkedList.add(m1s00.get(i));
                }

            }
        }

        /**
         * 第四步清空，生成细胞的兴奋细胞队列
         *
         */

        for (int i = 0; i < m1s0.size(); i++
        ) {
            cellWarehouse.getExcitedCellQueueForGenerateNewCell().poll();

        }
        m1s0.clear();
        m1s1.clear();
        m1s2.clear();
        m1s00.clear();

    }
}

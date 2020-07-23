package com.ncell.wangcai.service.cns.main.physiology.pojo.impl;

import com.ncell.wangcai.pojo.cns.main.base.Cell;
import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import com.ncell.wangcai.pojo.cns.main.warehouse.Warehouse;
import com.ncell.wangcai.service.cns.main.physiology.pojo.PojoRegisterService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * pojo注册，注销服务类
 * 新生成pojo，新兴奋pojo注册
 * 无用pojo，不在兴奋pojo注销
 *
 * 说明，暂时不使用其他pojo类型，所有的pojo都使用cell表示
 *
 * @author anliwei
 * @Date 2020/6/26 23:09
 */
@AllArgsConstructor
@Data
@Service("pojoRegisterServiceImpl")
public class PojoRegisterServiceImpl implements PojoRegisterService {

    Warehouse warehouse;
    CellWarehouse cellWarehouse;

    /**
     * 提供注册服务
     */
    @Override
    public void doRegisterService() {

    }

    /**
     * 新生产的pojo注册
     * 新生成的pojo，注册到CellWarehouse，
     *
     * 只注册到allCell
     * 暂时不注册到excitedCell避免出现兴奋嵌套
     *
     *
     * @param stemName
     * @param stem
     */
   // todo: 2020/6/27 不需要各种类型的细胞，增加编程复杂性

    @Override
    public void newPojoRegisterIn(String stemName, Stem stem) {

        cellWarehouse.getAllCell().put(stemName,(Cell) stem);

        //如果细胞名称包含text，单独再添加到text集合中,
        //XXX
        //todo 考虑以后需不需要区分各类细胞。
        String str="text";
        if(stemName.contains(str)){
            cellWarehouse.getTextCell().put(stemName,(Cell) stem);
        }


    }

    /**
     * 不用的pojo注销
     * 不仅仅是allCell
     * 如果其他集合中还有也应该一并删除
     *
     * @param stemName
     */
    @Override
    public void uselessPojoRegisterOut(String stemName) {

        cellWarehouse.getAllCell().remove(stemName);
        //如果其他集合中还有也应该一并删除
        if(cellWarehouse.getExcitedCell().containsKey(stemName)){
            cellWarehouse.getExcitedCell().remove(stemName);
        }

    }

    /**
     * 兴奋pojo注册
     *
     * @update
     * 2020年7月6日11:32:20
     * 只要是兴奋细胞，状态判断后的都可以注册，不存在重复注册的问题
     *
     * @param stemName
     */
    @Override
    public void excitedPojoRegisterIn(String stemName) {

        //注册到excitedCell集合
        cellWarehouse.getExcitedCell().put(stemName,cellWarehouse.getAllCell().get(stemName));
        //注册到兴奋队列
        cellWarehouse.getExcitedCellQueue().add(stemName);


    }

    /**
     * 不再兴奋pojo注销
     *
     * @param stemName
     */
    @Override
    public void unexcitedPojoRegisterOut(String stemName) {
        cellWarehouse.getExcitedCell().remove(stemName);
        //队列中的元素不能跳跃删除，只能等到使用的时候，再进行判定。
        //cellWarehouse.getExcitedCellQueue().

    }


}

package com.ncell.wangcai.utils.cns.main;

import com.ncell.wangcai.pojo.cns.main.base.Cell;
import com.ncell.wangcai.pojo.cns.main.part.Connection;
import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import com.ncell.wangcai.service.cns.main.physiology.connection.impl.ConnectionCreatServiceImpl;
import com.ncell.wangcai.service.cns.main.physiology.connection.impl.ConnectionRegisterServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author anliwei
 * @Date 2020/6/26 12:30
 */

@AllArgsConstructor
@Data
@Service("cellUtil")
public class CellUtil {

    CellWarehouse cellWarehouse;
    ConnectionCreatServiceImpl connectionCreatService;
    ConnectionRegisterServiceImpl connectionRegisterService;

    /**
     * 细胞分组工具
     */
    public void cellGroup() {

    }

    /**
     * 一阶导数分类法
     */
    void groupByFirstDerivative() {

    }

    /**
     * 二阶导数分类法
     */
    void groupBySecondDerivative() {

    }

    void cellRegister() {

    }

    public void creatCellByNameList(LinkedList linkedList) {


        //如果所有细胞都是一个类型细胞
        if (this.containSameCellType(linkedList)) {
            //取出一个元素，查看细胞类型是否是文字细胞，文字细胞的type值为，11.以后使用统一的全局变量来表示
            if (cellWarehouse.getAllCell().get((String) linkedList.peek()).getType() == 11) {
                //获取文字细胞的个数
                int cellNumber = cellWarehouse.getTextCell().size();
                //生成细胞的名称：textcell+数字
                String newCellName = "textCell" + Integer.toString(cellNumber);
                //根据细胞名称创造新细胞
                Cell newTextCell = this.creatTextCell(newCellName);
                //调整细胞元素，连接等变量
                //生成连接
                //将元素添加到新生成的细胞的输入连接中
                //将连接注册到连接仓库
                for (Object s : linkedList
                ) {
                    String FromCellName = (String) s;
                    newTextCell.getConnectionsInput().add(FromCellName);

                    //生产新的连接
                    Connection connection=connectionCreatService.getConnectionUtil().createConnectionByName(FromCellName,newCellName);

                    //将连接实例的名称添加到生成细胞的输出连接中
                    cellWarehouse.getAllCell().get(FromCellName).getConnectionsOutput().add(connection.getName());

                    //将新连接注册到连接仓库
                    connectionRegisterService.getConnectionUtil().registerConnection(connection);


                }
                //注册到静态仓库
                this.registerInBaseWarehouse(newTextCell);



            } else if (cellWarehouse.getAllCell().get((String) linkedList.peek()).getType() == 12) {
                //todo 增加创建声音细胞的代码
            } else if (cellWarehouse.getAllCell().get((String) linkedList.peek()).getType() == 13) {
                //todo 增加创建图形细胞的代码
            }
        }
        //如果有不同类型的细胞，以后与声音和图像细胞同时激活的时候
        else {
            //todo 增加创建混杂细胞的代码
        }
    }

    Boolean containSameCellType(LinkedList linkedList) {
        boolean flag = false;
        //判断方法，将所有的细胞的类型都放进一个集合中，如果集合的元素数量大于一个就表示，list中有不同的类型
        HashSet<Integer> set = new HashSet<Integer>();
        for (Object s : linkedList
        ) {
            set.add(cellWarehouse.getAllCell().get((String) s).getType());
        }
        if (set.size() > 1) {
            flag = false;
        } else {
            flag = true;
        }
        return flag;

    }

    Cell creatTextCell(String cellName) {

        Cell newCell = new Cell();
        newCell.setType(11);
        newCell.setCurrentState(1);
        newCell.setCurrentStateStartTime(System.currentTimeMillis());
        newCell.setName(cellName);
        return newCell;
    }

    /**
     * 注册到静态仓库
     *
     * @param cell
     */
    void registerInBaseWarehouse(Cell cell) {

        //注册到allCell中
        cellWarehouse.getAllCell().put(cell.getName(), cell);
        //注册到textCell中
        cellWarehouse.getTextCell().put(cell.getName(), cell);

    }
}

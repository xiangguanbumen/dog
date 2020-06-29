package com.ncell.wangcai.utils.cns.inputConverter;

import com.ncell.wangcai.pojo.cns.main.Cell;
import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 文字细胞工具类
 *
 * @author anliwei
 * @Data 2020/6/7 19:09
 */
@Data
@AllArgsConstructor
@Component("textCellUtil")
public class TextCellUtil {
    CellWarehouse cellWarehouse;

    /**
     * textcellUtil主方法，将其他服务整合起来，统一接口对外提供服务
     *
     * @param cellName
     */
    public void doService(String cellName) {

        Cell cell=null;
        //如果细胞不存在，创建并注册到allCell和textCell集合
        if (!this.textCellExist(cellName)) {
            cell=this.creatTextCell(cellName);
            this.registerInBaseWarehouse(cell);
        }
        //如果细胞存在,修改细胞状态
        else{
            cell=this.findCellByName(cellName);
            this.changeCellState(cellName);
        }
        //最后所有的textCell全部注册到几个工作集合中
        this.registerInWorkWarehouse(cell);

    }

    /**
     * 通过细胞名称查询细胞,这里是文字细胞工具类，所有在文字细胞库中查找
     */
    public Cell findCellByName(String cellName) {
        //在文字细胞仓库中查找，还是直接在所有细胞仓库中查找？这里使用文字仓库，减少主仓库查找压力
        Cell textCell = cellWarehouse.getTextCell().get(cellName);
        return textCell;
    }

    /**
     * 查询根据这个字符命名的细胞是否存在
     *
     * @return
     */

    Boolean textCellExist(String cellName) {
        //在文字仓库中查找
        return cellWarehouse.getTextCell().containsKey(cellName);
    }

    /**
     * 创造新的细胞
     * @param cellName
     * @return
     */

    Cell creatTextCell(String cellName) {

        Cell newCell = new Cell();
        newCell.setCurrentState(1);
        newCell.setCurrentStateStartTime(System.currentTimeMillis());
        newCell.setName(cellName);
        return newCell;
    }

    /**
     * 注册到静态仓库
     * @param cell
     */
    void registerInBaseWarehouse(Cell cell) {

        //注册到allCell中
        cellWarehouse.getAllCell().put(cell.getName(), cell);
        //注册到textCell中
        cellWarehouse.getTextCell().put(cell.getName(), cell);

    }

    /**
     * 注册到动态仓库
     * @param cell
     */
    void registerInWorkWarehouse(Cell cell) {
        //注册到excitedCell集合,同时注册细胞名称，和细胞实体
        cellWarehouse.getExcitedCell().put(cell.getName(), cell);
        //注册到兴奋队列中，只注册细胞名称
        cellWarehouse.getExcitedCellQueue().add(cell.getName());
        //注册到同一批次输入的包，只注册细胞名称
        cellWarehouse.getInputTextCellQueue().add(cell.getName());

    }

    /**
     * 改变细胞状态
     * @param cellName
     */
    void changeCellState(String cellName) {
        //如果存在激活细胞,找到它
        Cell textCell = this.findCellByName(cellName);
        //修改细胞状态
        textCell.setCurrentState(1);
        //修改细胞此次兴奋时间
        textCell.setCurrentStateStartTime(System.currentTimeMillis());

    }


}

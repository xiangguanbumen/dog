package com.ncell.wangcai.utils.cell;

import com.ncell.wangcai.pojo.cns.common.Cell;
import com.ncell.wangcai.pojo.cns.common.warehouse.CellWarehouse;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 文字细胞工具类
 *
 * @author anliwei
 * @Data 2020/6/7 19:09
 */
@NoArgsConstructor
@Component("textCellUtil")
public class TextCellUtil {

    /**
     * 通过细胞名称查询细胞
     */
    public Cell findCellByName(String cellName,CellWarehouse cellWarehouse){

        Cell textCell = cellWarehouse.getTextCell().get(cellName);
        return textCell;
    }
    /**
     * 查询根据这个字符命名的细胞是否存在
     * @param cellWarehouse
     * @return
     */

    public Boolean textCellExist(String cellName , CellWarehouse cellWarehouse){

        if(cellWarehouse.getAllCell().containsKey(cellName)){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 获取textcell的数量
     * 暂时不使用数字编号命名，其他没有实际编码的细胞再使用数字命名
     */

    public int textCellCount(ConcurrentHashMap<String, Cell> textCell){
        return textCell.size();
    }

    public Cell creatTextCell(Character character){

        Cell newCell = new Cell();
        newCell.setCurrentState(1);
        newCell.setCurrentStateStartTime(System.currentTimeMillis());
        newCell.setName("textCell"+character);
        return newCell;
    }

    public void registerTextCell(Cell cell,CellWarehouse cellWarehouse){

        //注册到allCell中
        cellWarehouse.getAllCell().put(cell.getName(),cell);
        //注册到textCell中
        cellWarehouse.getTextCell().put(cell.getName(),cell);
        //注册到excitedCell中
        cellWarehouse.getExcitedCell().put(cell.getName(),cell);
    }

    public void exciteAndRegisterTextCell(String cellName,CellWarehouse cellWarehouse){
        //如果存在激活细胞,找到它
        Cell textCell = this.findCellByName(cellName,cellWarehouse);
        //修改细胞参数
        textCell.setCurrentState(1);
        textCell.setCurrentStateStartTime(System.currentTimeMillis());

        //注册到excitedhashmap中
        cellWarehouse.getExcitedCell().put(textCell.getName(),textCell);

    }


}

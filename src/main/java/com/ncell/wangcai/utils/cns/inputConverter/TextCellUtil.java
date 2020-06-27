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
        //如果细胞不存在，创建并注册到allCell和textCell集合
        if (!this.textCellExist(cellName)) {
            this.registerTextCell(this.creatTextCell(cellName));
        }
        cellWarehouse.getInputTextCellQueue().add(cellName);
    }

    /**
     * 通过细胞名称查询细胞
     */
    public Cell findCellByName(String cellName) {

        Cell textCell = cellWarehouse.getTextCell().get(cellName);
        return textCell;
    }

    /**
     * 查询根据这个字符命名的细胞是否存在
     *
     * @return
     */

    Boolean textCellExist(String cellName) {

        return cellWarehouse.getAllCell().containsKey(cellName);
    }


    Cell creatTextCell(String cellName) {

        Cell newCell = new Cell();
        newCell.setCurrentState(1);
        newCell.setCurrentStateStartTime(System.currentTimeMillis());
        newCell.setName(cellName);
        return newCell;
    }

    void registerTextCell(Cell cell) {

        //注册到allCell中
        cellWarehouse.getAllCell().put(cell.getName(), cell);
        //注册到textCell中
        cellWarehouse.getTextCell().put(cell.getName(), cell);
        //注册到excitedCell中,
        // 2020年6月27日12:22:16 注册到兴奋细胞集合的服务由其他类进行，因为要进行包判断，决定是否分组进行激活
        // 2020年6月27日12:30:16 可以多进程同时处理一个细胞，所有这里也可以注册到兴奋队列和兴奋集合
        cellWarehouse.getExcitedCell().put(cell.getName(), cell);
        cellWarehouse.getExcitedCellQueue().add(cell.getName());

    }

    void exciteAndRegisterTextCell(String cellName) {
        //如果存在激活细胞,找到它
        Cell textCell = this.findCellByName(cellName);
        //修改细胞参数
        textCell.setCurrentState(1);
        textCell.setCurrentStateStartTime(System.currentTimeMillis());

        //注册到excitedhashmap中
        cellWarehouse.getExcitedCell().put(textCell.getName(), textCell);


    }


}

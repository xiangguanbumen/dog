package com.ncell.wangcai.utils.cns.inputConverter;

import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 成组输入的细胞的处理工具
 * @author anliwei
 * @Date 2020/7/11 16:51
 */
@AllArgsConstructor
@Data
@Component("textCellListUtil")
public class TextCellListUtil {
    CellWarehouse cellWarehouse;
    TextCellUtil textCellUtil;

    public void doService(List cellNameList){

    }
}

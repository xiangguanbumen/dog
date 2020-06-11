package com.ncell.wangcai.utils.cns.starter;

import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import com.ncell.wangcai.pojo.cns.main.warehouse.ConnectionWarehouse;
import com.ncell.wangcai.pojo.cns.main.warehouse.ElementWarehouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author anliwei
 * @Data 2020/6/11 9:51
 */
@Component("loadCellUtil")
@AllArgsConstructor
@Data
public class LoadCellUtil {

    CellWarehouse cellWarehouse;
    ConnectionWarehouse connectionWarehouse;
    ElementWarehouse elementWarehouse;



}

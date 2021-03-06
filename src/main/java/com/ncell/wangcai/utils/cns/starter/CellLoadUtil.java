package com.ncell.wangcai.utils.cns.starter;

import com.ncell.wangcai.warehouse.product.CellWarehouse;
import com.ncell.wangcai.warehouse.product.ConnectionWarehouse;
import com.ncell.wangcai.warehouse.product.ElementWarehouse;
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
public class CellLoadUtil {

    CellWarehouse cellWarehouse;
    ConnectionWarehouse connectionWarehouse;
    ElementWarehouse elementWarehouse;



}

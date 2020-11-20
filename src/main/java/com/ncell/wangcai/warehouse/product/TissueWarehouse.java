package com.ncell.wangcai.warehouse.product;

import com.ncell.wangcai.pojo.cns.main.base.Tissue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author anliwei
 * @Data 2020/6/7 12:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("tissueWarehouse")
public class TissueWarehouse {

    String name = "tissueWarehouse";

    /**
     * 所有tissue
     */
    ConcurrentHashMap<String, Tissue> allTissue = new ConcurrentHashMap(1024000);

    /**
     * 兴奋tissue
     */

    ConcurrentHashMap<String, Tissue> excitedTissue = new ConcurrentHashMap(1024000);

    /**
     * 部分兴奋tissue
     */

    ConcurrentHashMap<String, Tissue> partExcitedTissue = new ConcurrentHashMap(1024000);

}

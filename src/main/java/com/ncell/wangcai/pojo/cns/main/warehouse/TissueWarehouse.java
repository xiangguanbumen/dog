package com.ncell.wangcai.pojo.cns.main.warehouse;

import com.ncell.wangcai.pojo.cns.main.Cell;
import com.ncell.wangcai.pojo.cns.main.Tissue;
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

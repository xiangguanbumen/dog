package com.ncell.wangcai.pojo.cns.common.warehouse;

import com.ncell.wangcai.pojo.cns.common.Cell;
import com.ncell.wangcai.pojo.cns.common.Tissue;
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
     * 所有细胞
     */
    ConcurrentHashMap<String, Tissue> allTissue = new ConcurrentHashMap(1024000);
}

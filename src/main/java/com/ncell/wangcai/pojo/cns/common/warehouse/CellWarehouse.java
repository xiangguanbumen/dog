package com.ncell.wangcai.pojo.cns.common.warehouse;

import com.ncell.wangcai.pojo.cns.common.Cell;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 细胞仓库,为了减少主ConcurrentHashMap的查询修改压力，不同类型的细胞，建立各自的ConcurrentHashMap。
 * 先查询或修改各个类型细胞的ConcurrentHashMap，然后同步到主ConcurrentHashMap，及其他功能运行的ConcurrentHashMap
 *
 * @author anliwei
 * @Data 2020/6/7 11:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("cellWarehouse")
public class CellWarehouse {
    /**
     * 所有细胞
     */
    ConcurrentHashMap<String,Cell> allCell = new ConcurrentHashMap(1024000);
    /**
     * 正在兴奋的细胞
     */
    ConcurrentHashMap<String,Cell> excitedCell = new ConcurrentHashMap(1024000);
    /**
     * 部分兴奋细胞
     */
    ConcurrentHashMap<String,Cell> partExcitedCell = new ConcurrentHashMap(1024000);
    /**
     * 刚刚兴奋完，不应期细胞
     */
    ConcurrentHashMap<String,Cell> refractoryCell = new ConcurrentHashMap(1024000);


    /**
     * 文字细胞
     */
    ConcurrentHashMap<String,Cell> textCell = new ConcurrentHashMap(1024000);

}

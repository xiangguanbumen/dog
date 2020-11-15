package com.ncell.wangcai.warehouse.product;

import com.ncell.wangcai.pojo.cns.main.part.ElementJs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 动态样式仓库（动态关系细胞仓库）
 *
 * @author anliwei
 * @Data 2020/6/7 12:13
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component("elementJsWarehouse")
public class ElementJsWarehouse {
    /**
     * 所有动态式样
     */
    ConcurrentHashMap<String, ElementJs> allElementJs = new ConcurrentHashMap(1024000);
}

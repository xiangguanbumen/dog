package com.ncell.wangcai.pojo.cns.main.warehouse;

import com.ncell.wangcai.pojo.cns.main.part.ElementCss;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 静态样式仓库（静态关系细胞仓库）
 *
 * @author anliwei
 * @Data 2020/6/7 12:13
 */
@Component("elementCssWarehouse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementCssWarehouse {
    /**
     * 所有静态式样
     */
    ConcurrentHashMap<String, ElementCss> allElementCss = new ConcurrentHashMap(1024000);
}

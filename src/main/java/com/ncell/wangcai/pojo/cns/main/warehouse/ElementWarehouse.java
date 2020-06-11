package com.ncell.wangcai.pojo.cns.main.warehouse;

import com.ncell.wangcai.pojo.cns.main.part.Element;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author anliwei
 * @Data 2020/6/11 10:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("elementWarehouse")
public class ElementWarehouse {
    ConcurrentHashMap<String, Element>  allElement= new ConcurrentHashMap<String, Element>(10240000);
}

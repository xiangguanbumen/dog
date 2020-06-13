package com.ncell.wangcai.pojo.cns.main.runtime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 不是所有的兴奋细胞都有
 * @author anliwei
 * @Date 2020/6/11 20:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("runningPojoCenter")
public class RunningPojoCenter {
    /**
     * 第一个string保存产生消息的pojo的名称，第二个String没有意义可以重复，因为没有并发set，使用hashMap取代
     */
    ConcurrentHashMap<String, String> pojoInRunningPojoCenter = new ConcurrentHashMap(1024000);




}

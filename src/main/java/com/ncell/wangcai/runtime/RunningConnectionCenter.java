package com.ncell.wangcai.runtime;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author anliwei
 * @Date 2020/6/11 20:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("runningConnectionCenter")
public class RunningConnectionCenter {

    /**
     * 第一个string保存产生connection的pojo的名称，第二个String保存没有目的地connection名称
     */
    ConcurrentHashMap<String, String> connectionInRunningConnectionCenter = new ConcurrentHashMap(1024000);
}

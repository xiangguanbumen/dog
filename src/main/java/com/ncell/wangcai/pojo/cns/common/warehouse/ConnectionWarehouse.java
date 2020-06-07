package com.ncell.wangcai.pojo.cns.common.warehouse;

import com.ncell.wangcai.pojo.cns.common.Cell;
import com.ncell.wangcai.pojo.cns.common.part.Connection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 连接仓库
 *
 * @author anliwei
 * @Data 2020/6/7 12:11
 */
@Component("connectionWarehouse")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConnectionWarehouse {
    ConcurrentHashMap<String, Connection> allConnection = new ConcurrentHashMap(1024000);

    /**
     * 连接建立时间小于某一个时间阈值的，可以舍弃的
     */
    ConcurrentHashMap<String, Connection> newConnection = new ConcurrentHashMap(1024000);

    /**
     * 连接建立次数小于某一个阈值的，可以舍弃的
     */
    ConcurrentHashMap<String, Connection> weakConnection = new ConcurrentHashMap(1024000);
}

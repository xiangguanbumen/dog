package com.ncell.wangcai.warehouse.product;

import com.ncell.wangcai.pojo.cns.main.part.Connection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 连接仓库
 *
 * @author anliwei
 * @Date 2020/6/7 12:11
 */
@Component("connectionWarehouse")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConnectionWarehouse {

    /**
     * 所有连接，通过连接名称索引
     */
    ConcurrentHashMap<String, Connection> allConnection = new ConcurrentHashMap(1024000);

    /**
     * 所有连接，通过连接发出方索引
     */
    ConcurrentHashMap<String, Connection> allConnectionByConnectionFrom = new ConcurrentHashMap(1024000);

    /**
     * 所有连接，通过连接接受方索引
     */
    ConcurrentHashMap<String, Connection> allConnectionByConnectionTo = new ConcurrentHashMap(1024000);

    /**
     * 连接建立时间小于某一个时间阈值的，可以舍弃的
     */
    ConcurrentHashMap<String, Connection> newConnection = new ConcurrentHashMap(1024000);

    /**
     * 连接建立次数小于某一个阈值的，可以舍弃的
     */
    ConcurrentHashMap<String, Connection> weakConnection = new ConcurrentHashMap(1024000);
}

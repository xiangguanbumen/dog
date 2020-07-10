package com.ncell.wangcai.service.cns.main.physiology.connection;

import com.ncell.wangcai.pojo.cns.main.part.Connection;

/**
 * @author anliwei
 * @Date 2020/7/9 13:33
 */
public interface ConnectionRegisterService {

    /**
     * 注册连接到连接仓库
     * @param connection
     */
    void registerConnection(Connection connection);
}

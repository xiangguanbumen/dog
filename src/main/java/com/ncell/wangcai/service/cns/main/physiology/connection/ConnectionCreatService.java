package com.ncell.wangcai.service.cns.main.physiology.connection;

/**
 * @author anliwei
 * @Date 2020/6/23 19:49
 */
public interface ConnectionCreatService {
    /**
     * 创建连接
     * @param from
     * @param to
     */
    void createConnectionByName(String from,String to);
}

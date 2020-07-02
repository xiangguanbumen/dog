package com.ncell.wangcai.service.mapperService;

import com.ncell.wangcai.pojo.cns.main.part.Connection;

import java.util.List;

/**
 * @author anliwei
 * @Data 2020/6/11 15:03
 */
public interface ConnectionMapperService {

    /**
     * 删除
     * @param connectionName
     * @return
     */
    int deleteConnection(String connectionName);

    /**
     * 通过owner查找
     * @param ownerName
     * @return
     */
    List<Connection> findConnectionByOwnerName(String ownerName);

    /**
     * 保存
     * @param connection
     * @return
     */
    int addConnection(Connection connection);

    /**
     *
     * 找到所有connection
     * @return
     */
    List<Connection> findAllConnection();
}

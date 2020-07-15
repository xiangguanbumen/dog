package com.ncell.wangcai.service.mapperService.impl;

import com.ncell.wangcai.mapper.ConnectionMapper;
import com.ncell.wangcai.pojo.cns.main.part.Connection;
import com.ncell.wangcai.service.mapperService.ConnectionMapperService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author anliwei
 * @Data 2020/6/11 15:06
 */
@Data
@AllArgsConstructor
@Service("connectionMapperServiceImpl")
public class ConnectionMapperServiceImpl implements ConnectionMapperService {

    ConnectionMapper connectionMapper;
    /**
     * 删除
     *
     * @param connectionName
     * @return
     */
    @Override
    public int deleteConnection(String connectionName) {
        return connectionMapper.deleteConnection(connectionName);
    }

    /**
     * 通过owner查找
     *
     * @param ownerName
     * @return
     */
    @Override
    public List<Connection> findConnectionByOwnerName(String ownerName) {
        return connectionMapper.findConnectionByOwnerName(ownerName);
    }

    /**
     * 保存
     *
     * @param connection
     * @return
     */
    @Override
    public int addConnection(Connection connection) {
        return connectionMapper.addConnection(connection);
    }

    /**
     * 找到所有connection
     *
     * @return
     */
    @Override
    public List<Connection> findAllConnection() {
        return connectionMapper.findAllConnection();
    }

    /**
     * 清空数据库connection_table
     */
    @Override
    public void truncateTable() {
         connectionMapper.truncateTable();
    }
}

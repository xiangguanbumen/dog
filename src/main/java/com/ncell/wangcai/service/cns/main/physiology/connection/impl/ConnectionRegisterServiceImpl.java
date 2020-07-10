package com.ncell.wangcai.service.cns.main.physiology.connection.impl;

import com.ncell.wangcai.pojo.cns.main.part.Connection;
import com.ncell.wangcai.service.cns.main.physiology.connection.ConnectionRegisterService;
import com.ncell.wangcai.utils.cns.main.CellUtil;
import com.ncell.wangcai.utils.cns.main.ConnectionUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author anliwei
 * @Date 2020/7/9 13:39
 */
@AllArgsConstructor
@Data
@Service("connectionRegisterServiceImpl")
public class ConnectionRegisterServiceImpl implements ConnectionRegisterService {

    ConnectionUtil connectionUtil;

    /**
     * 注册连接到连接仓库
     *
     * @param connection
     */
    @Override
    public void registerConnection(Connection connection) {
        connectionUtil.registerConnection(connection);
    }
}

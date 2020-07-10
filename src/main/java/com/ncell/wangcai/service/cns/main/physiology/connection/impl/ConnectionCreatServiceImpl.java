package com.ncell.wangcai.service.cns.main.physiology.connection.impl;

import com.ncell.wangcai.pojo.cns.main.warehouse.ConnectionWarehouse;
import com.ncell.wangcai.service.cns.main.physiology.connection.ConnectionCreatService;
import com.ncell.wangcai.utils.cns.main.ConnectionUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author anliwei
 * @Date 2020/6/23 19:50
 */
@AllArgsConstructor
@Data
@Service("connectionCreatServiceImpl")
public class ConnectionCreatServiceImpl implements ConnectionCreatService {

    ConnectionUtil connectionUtil;

    /**
     * 创建连接
     *
     * @param from
     * @param to
     */
    @Override
    public void createConnectionByName(String from, String to) {
        connectionUtil.createConnectionByName(from,to);
    }
}

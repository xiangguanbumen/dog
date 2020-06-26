package com.ncell.wangcai.service.cns.main.physiology.message.impl;

import com.ncell.wangcai.pojo.cns.main.runtime.RunningPojoCenter;
import com.ncell.wangcai.pojo.cns.main.warehouse.MessageWarehouse;
import com.ncell.wangcai.service.cns.main.physiology.message.MessageSelect;

/**
 * @update
 * 2020年6月26日16:01:37
 * 也许可以通过使用消息发送频率，和强度来确定注意的范围
 * @author anliwei
 * @Date 2020/6/20 18:08
 */
public class MessageSelectImpl implements MessageSelect {

    RunningPojoCenter runningPojoCenter;
    MessageWarehouse messageWarehouse;
    /**
     * 执行消息选择的主方法
     */
    @Override
    public void doSelectService() {

    }

    /**
     * 查找running仓库中实体类
     *
     * @return
     */
    @Override
    public String getRunningPojo() {
        return null;
    }
}

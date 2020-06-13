package com.ncell.wangcai.service.cns.main.physiology.impl;

import com.ncell.wangcai.service.cns.main.physiology.PojoRunService;
import org.springframework.stereotype.Service;

/**
 * @author anliwei
 * @create 2020/6/8 19:49
 */
@Service("stemServiceImpl")
public class PojoRunServiceImpl implements PojoRunService {


    /**
     * 比较接收到的消息和自身的element
     *
     * @return
     */
    @Override
    public Boolean compare() {
        return null;
    }

    /**
     * 发送消息到自身的连接结构
     */
    @Override
    public void fire() {

    }
}

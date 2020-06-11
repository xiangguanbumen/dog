package com.ncell.wangcai.service.cns.main.physiology;

/**
 * @author anliwei
 * @create 2020/6/8 19:26
 */
public interface PojoRunService {
    /**
     * 对接收到的消息和自身的element
     * @return
     */
     Boolean compare();

    /**
     * 发送消息到自身的连接结构
     */
    void fire();


}

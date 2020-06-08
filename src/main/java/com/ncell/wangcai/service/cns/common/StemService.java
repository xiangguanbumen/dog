package com.ncell.wangcai.service.cns.common;

/**
 * @author anliwei
 * @create 2020/6/8 19:26
 */
public interface StemService {
    /**
     * 对接收到的消息和自身的element
     * @return
     */
     Boolean compare();

    /**
     * 发送消息到自身的连接结构
     */
    void fire();

    /**
     * 更新自身连接
     */
    void updateConnection();

    /**
     * 更新自身组成元素
     */
    void updateElement();

    /**
     * 更新自身组成元素静态布局
     */
    void updateElementCss();

    /**
     * 更新自身组成元素动态布局
     */
    void updateElementJs();
}

package com.ncell.wangcai.service.cns.main.physiology.pojo;

/**
 * @author anliwei
 * @Data 2020/6/11 20:24
 */
public interface PojoUpDateService {

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

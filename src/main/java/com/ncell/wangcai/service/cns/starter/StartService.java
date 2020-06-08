package com.ncell.wangcai.service.cns.starter;

/**
 * @author anliwei
 * @create 2020/6/8 18:04
 */
public interface StartService {
    /**
     * 从数据库加载cell实例
     */
    void loadCell();

    /**
     * 从数据库加载Tissue实例
     */
    void loadTissue();

    /**
     * 从数据库加载Agent实例
     */
    void loadAgent();

    /**
     * 从数据库加载Scene实例
     */
    void loadScene();

    /**
     * 从数据库加载Story实例
     */
    void loadStory();

    /**
     * 从数据库加载Connection到各个已经加载的实例
     */
    void loadConnection();

    /**
     * 从数据库加载Message到各个已经加载的实例
     */
    void loadMessage();

    /**
     * 从数据库加载ElementJs到各个已经加载的实例
     */
    void loadElement();

    /**
     * 从数据库加载ElementCss到各个已经加载的实例
     */
    void loadElementCss();

    /**
     * 从数据库加载ElementJs到各个已经加载的实例
     */
    void loadElementJs();

}

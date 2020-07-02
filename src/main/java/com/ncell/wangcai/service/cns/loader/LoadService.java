package com.ncell.wangcai.service.cns.loader;

/**
 * @author anliwei
 * @create 2020/6/8 18:04
 */
public interface LoadService {

    /**
     * loadService主方法，调用其他pojo加载方法
     */
    void doLoadService();

    /**
     * load 主体pojo
     */
    void loadBasePojo();

    /**
     * 加载pojo实体类的各种组成部分，如connection。message。element等
     *
     */
    void loadPojoPart();


    /**
     * 加载pojo实体类的各种组成部分，如connection。message。element等
     * @param name
     */
    void loadPartForOnePojo(String name);
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
     *

     */
    void loadConnection();

    /**
     * 从数据库加载Message到各个已经加载的实例
     */
    void loadMessage();

    /**
     * 从数据库加载Element到各个已经加载的实例
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

    /**
     * 从数据库加载Connection到各个已经加载的实例
     *
     * @param name
     */
    void loadConnection(String name);

    /**
     * 从数据库加载Message到各个已经加载的实例
     * @param name
     */
    void loadMessage(String name);

    /**
     * 从数据库加载Element到各个已经加载的实例
     * @param name
     */
    void loadElement(String name);

    /**
     * 从数据库加载ElementCss到各个已经加载的实例
     * @param name
     */
    void loadElementCss(String name);

    /**
     * 从数据库加载ElementJs到各个已经加载的实例
     * @param name
     */
    void loadElementJs(String name);

}

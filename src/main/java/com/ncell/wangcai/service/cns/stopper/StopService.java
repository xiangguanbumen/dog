package com.ncell.wangcai.service.cns.stopper;

/**
 * @author anliwei
 * @create 2020/6/10 11:50
 */
public interface StopService {
    /**
     * 停止服务主方法分别依次调用其他各个save方法
     */
    void doStopService();

    /**
     * 存储实体的根方法
     */
    void saveStem();
    /**
     * 存储细胞实体
     */
    void saveCell();

    /**
     * 存储tissue实体
     */
    void saveTissue();

    /**
     * 存储agent实体
     */
    void saveAgent();

    /**
     * 存储scene实体
     */
    void saveScene();

    /**
     * 存储story实体
     */
    void saveStory();


    /**
     * 存储connection实体
     */
    void saveConnection();

    /**
     * 存储message实体
     */
    void saveMessage();

    /**
     * 存储element实体
     */
    void saveElement();

    /**
     * 存储elementCss实体
     */
    void saveElementCss();

    /**
     * 存储elementJs实体
     */
    void saveElementJs();




}

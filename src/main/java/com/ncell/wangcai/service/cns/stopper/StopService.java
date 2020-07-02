package com.ncell.wangcai.service.cns.stopper;

import com.ncell.wangcai.pojo.cns.main.stem.Stem;

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
     * 存储pojo实体
     */
    void savePojo();


    /**
     * 存储实体的组成部分
     */
    void savePart();
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


    /**
     * 存储实体的组成部分
     * @param stem
     */
    void savePart(Stem stem);


    /**
     * 存储connection实体
     * @param stem
     */
    void saveConnection(Stem stem);

    /**
     * 存储message实体
     * @param stem
     */
    void saveMessage(Stem stem);

    /**
     * 存储element实体
     * @param stem
     */
    void saveElement(Stem stem);

    /**
     * 存储elementCss实体
     * @param stem
     */
    void saveElementCss(Stem stem);

    /**
     * 存储elementJs实体
     * @param stem
     */
    void saveElementJs(Stem stem);




}

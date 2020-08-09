package com.ncell.wangcai.serviceset.trainservice.locallearn;

import java.io.File;

/**
 * @author anliwei
 * @Date 2020/7/9 15:17
 */
public interface LocalLearnService {
    /**
     * 文档学习
     *
     */
    void learnDoc();

    /**
     * 声音学习
     */
    void learnSound();

    /**
     * 图像学习
     */
    void learnImage();

    /**
     * 视频学习
     */
    void learnVideo();

    /**
     * 声音学习
     * @param file
     */
    void learnSound(File file);

    /**
     * 图像学习
     * @param file
     */
    void learnImage(File file);

    /**
     * 视频学习
     * @param file
     */
    void learnVideo(File file);






}

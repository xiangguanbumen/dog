package com.ncell.wangcai.service.dogService.trainer;

/**
 * @author anliwei
 * @Date 2020/7/9 15:52
 */
public interface StartTrainService {
    /**
     * 开启startLearn服务
     */
    void doStartTrainService();




    /**
     * 文档学习
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

}

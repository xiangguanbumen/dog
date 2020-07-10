package com.ncell.wangcai.service.dogService.trainer;

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

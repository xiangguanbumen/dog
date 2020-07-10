package com.ncell.wangcai.service.dogService.trainer;

/**
 * @author anliwei
 * @Date 2020/7/9 15:22
 */
public interface WebLearnService {
    /**
     * 从指定网站学习
     * @param URL
     */
   void learnOneSite(String URL);

    /**
     * 从全网学习，需要指定开始网页学习
     * @param startURL
     */
    void learnAllSite(String startURL);
}

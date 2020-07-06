package com.ncell.wangcai.service.cns.starter;

/**
 * @author anliwei
 * @Date 2020/6/27 16:44
 */
public interface StartService {

    /**
     * 生成新的pojo，根据兴奋细胞组合
     */
    void createPojo();

    /**
     * 产生消息（但是只是发送到消息仓库）
     */
    void releaseImpulse();

    /**
     * 根据收到的消息决定细胞的状态
     */
    void changeState();

    /**
     * 发送消息到具体目标细胞
     */
    void sendMessage();

}

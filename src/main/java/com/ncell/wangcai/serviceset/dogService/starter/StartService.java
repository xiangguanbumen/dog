package com.ncell.wangcai.serviceset.dogService.starter;

/**
 * @author anliwei
 * @Date 2020/6/27 16:44
 */
public interface StartService {

    /**
     * 开启starter服务
     */
    void doStartService();

    /**
     * 生成新的pojo，根据兴奋细胞组合
     */
    void createPojo() throws InterruptedException;

    /**
     * 产生消息（但是只是发送到消息仓库）
     */
    void releaseImpulse() throws InterruptedException;

    /**
     * 根据收到的消息决定细胞的状态
     */
    void changeState() throws InterruptedException;

    /**
     * 发送消息到具体目标细胞
     */
    void sendMessage() throws InterruptedException;

    /**
     * 获取输入，输入标准化
     */
    void getInput();

    /**
     * 转换输入成细胞
     */
    void convertInput() throws InterruptedException;


}

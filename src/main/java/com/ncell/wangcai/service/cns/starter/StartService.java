package com.ncell.wangcai.service.cns.starter;

/**
 * @author anliwei
 * @Date 2020/6/27 16:44
 */
public interface StartService {
    /**
     * 从数据库加载
     */
    void loadPojo();

    /**
     * 生成新的pojo，根据兴奋细胞组合
     */
    void createPojo();

    /**
     * 发送神经冲动，产生消息（但是只是发送到消息仓库）
     */
    void releaseImpulse();

    /**
     * 根据收到的消息决定细胞的状态
     */
    void changeState();

}

package com.ncell.wangcai.service.cns.main.physiology.message;

import com.ncell.wangcai.pojo.cns.main.part.Message;

/**
 * 将消息仓库中的消息发送到消息的接收细胞
 * @author anliwei
 * @create 2020/7/6 9:55
 */
public interface MessageSendService {
    /**
     * 遍历消息仓库，根据消息的内容，将消息仓库中的消息发送到消息的接收细胞
     *
     */
    void doSendMessageService();
}

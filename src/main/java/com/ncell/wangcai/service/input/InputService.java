package com.ncell.wangcai.service.input;

/**
 * @author anliwei
 * @Data 2020/6/6 12:20
 */
public interface InputService {
    /**
     * 获取数据
     */
    void obtainData();

    /**
     * 标准化数据
     */
    void normalizeData();

    /**
     * 发送数据
     */
    void sendData();
}

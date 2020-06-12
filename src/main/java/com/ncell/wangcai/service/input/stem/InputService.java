package com.ncell.wangcai.service.input.stem;

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
     * 2020年6月7日00:01:32
     * 以后将程序部署为分布式，在使用restfull编码，每一个都对应一个接口，目前只是分层，没有分布。
     * 不需要senddata，高层来低层的仓库取数据就可以了
     */
    void sendData() throws InterruptedException;
}

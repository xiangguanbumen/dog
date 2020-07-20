package com.ncell.wangcai.service.cns.inputConverter;

/**
 * @author anliwei
 * @Data 2020/6/7 16:53
 */
public interface DocumentToCellConvertService {

    /**
     *
     * 集合三个方法，获取转换，发送
     */
    void doService() throws InterruptedException;

    /**
     * 获取数据
     */
    void obtainData();

    /**
     * 将用户输入的文字转换成细胞
     * @throws InterruptedException
     */
    void convertDocToCell() throws InterruptedException;
    /**
     * 将细胞发送到细胞仓库
     */
    void sendCell();


}

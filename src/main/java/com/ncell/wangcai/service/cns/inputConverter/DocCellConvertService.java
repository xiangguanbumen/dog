package com.ncell.wangcai.service.cns.inputConverter;

/**
 * @author anliwei
 * @Data 2020/6/7 16:53
 */
public interface DocCellConvertService {
    /**
     * 获取数据
     */
    void obtainData();
    /**
     * 转换数据为细胞
     */
    void convertDocToCell() throws InterruptedException;
    /**
     * 将细胞发送到细胞仓库
     */
    void sendCell();

    /**
     * 集合三个方法，获取转换，发送
     *
     */
    void doService() throws InterruptedException;
}

package com.ncell.wangcai.service.cns.main.physiology.pojo;

/**
 * pojo分组服务，
 * 根据各种维度的拐点将兴奋pojo进行分组，
 * 时间分类法，空间分类法， 连接强度分类法，普遍适用于所有的兴奋pojo集合。
 *
 * @author anliwei
 * @Date 2020/6/26 8:39
 */
public interface PojoGroupService {


    /**
     * 按照时间分组
     */
    void groupByTimeService();

    /**
     * 按照空间分组
     */
    void groupBySpaceService();

    /**
     * 按照特殊细胞分组（主要是拐点细胞）。这种方法是一个导数的分类思想，首先需要找到拐点细胞
     */
    void groupByDerivativeService();


    //针对连接
    /**
     * 按照连接频率分组
     */
    void groupByConnectionFrequency();

    /**
     * 按照连接强度分组
     */
    void groupByConnectionStrength();



    //针对图像
    /**
     * 按照灰度分组
     */
    void groupByColorGray();

    /**
     * 按照绿色分组
     */
    void groupByColorGreen();

    /**
     * 按照蓝色分组
     */
    void groupByColorBlue();

    /**
     * 按照红色分组
     */
    void groupByColorRed();

    //针对声音
    /**
     * 按照音量分组
     */
    void groupBySoundVolume();

    /**
     * 按照音频分组
     */
    void groupBySoundFrequency();





}

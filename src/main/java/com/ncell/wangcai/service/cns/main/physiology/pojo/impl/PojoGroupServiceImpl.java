package com.ncell.wangcai.service.cns.main.physiology.pojo.impl;

import com.ncell.wangcai.pojoruntime.cns.main.RunningPojoCenter;
import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import com.ncell.wangcai.service.cns.main.physiology.pojo.PojoGroupService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *  pojo分组服务，
 *  根据各种维度的拐点将兴奋pojo进行分组，
 *  时间分类法，空间分类法， 连接强度分类法，普遍适用于所有的兴奋pojo集合
 *

 * @author anliwei
 * @Date 2020/6/26 10:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Service("pojoGroupServiceImpl")
public class PojoGroupServiceImpl implements PojoGroupService {
    RunningPojoCenter runningPojoCenter;
    CellWarehouse cellWarehouse;


    /**
     * 按照时间分组
     *
     * 时间分割的阈值确定是难点。因为不同类型的感觉分割是不同的时间
     */
    @Override
    public void groupByTimeService() {
    //todo 时间片段的阈值确定

    }

    /**
     * 按照空间分组
     */
    @Override
    public void groupBySpaceService() {

    }

    /**
     * 按照特殊细胞分组（主要是拐点细胞）。这种方法是一个导数的分类思想，首先需要找到拐点细胞
     *
     * 可以生成多阶分组，
     * 一维信号的高阶分组是一个二维的三角形，
     * 二维信号的高阶分组是一个三维的金字塔。
     */
    @Override
    public void groupByDerivativeService() {

    }

    /**
     * 按照连接频率分组
     */
    @Override
    public void groupByConnectionFrequency() {

    }

    /**
     * 按照连接强度分组
     */
    @Override
    public void groupByConnectionStrength() {

    }

    /**
     * 按照灰度分组
     */
    @Override
    public void groupByColorGray() {

    }

    /**
     * 按照绿色分组
     */
    @Override
    public void groupByColorGreen() {

    }

    /**
     * 按照蓝色分组
     */
    @Override
    public void groupByColorBlue() {

    }

    /**
     * 按照红色分组
     */
    @Override
    public void groupByColorRed() {

    }

    /**
     * 按照音量分组
     */
    @Override
    public void groupBySoundVolume() {

    }

    /**
     * 按照音频分组
     */
    @Override
    public void groupBySoundFrequency() {

    }
}

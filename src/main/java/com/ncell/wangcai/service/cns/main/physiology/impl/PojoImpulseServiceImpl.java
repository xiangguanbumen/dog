package com.ncell.wangcai.service.cns.main.physiology.impl;

import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import com.ncell.wangcai.service.cns.main.physiology.PojoImpulseService;

/**
 *
 * pojo的神经冲动发放。
 * 发放之后，这一次的兴奋全部完成，pojo进入不应期。
 *
 * @author anliwei
 * @Date 2020/6/13 22:30
 */
public class PojoImpulseServiceImpl implements PojoImpulseService {
    /**
     * 发送消息到自身的连接结构
     *
     * @param stem
     */
    @Override
    public void fire(Stem stem) {

    }
}

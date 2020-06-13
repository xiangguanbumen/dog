package com.ncell.wangcai.service.cns.main.physiology;

import com.ncell.wangcai.pojo.cns.main.stem.Stem;

/**
 * @author anliwei
 * @Date 2020/6/13 22:23
 */
public interface PojoImpulseService {

    /**
     * 发送消息到自身的连接结构
     * @param stem
     */
    void fire(Stem stem);
}

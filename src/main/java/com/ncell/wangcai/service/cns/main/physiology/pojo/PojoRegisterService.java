package com.ncell.wangcai.service.cns.main.physiology.pojo;

import com.ncell.wangcai.pojo.cns.main.stem.Stem;

/**
 * @author anliwei
 * @Date 2020/6/26 22:46
 */
public interface PojoRegisterService {
    /**
     * 提供注册服务
     */
    void doRegisterService();

    /**
     * 新生产的pojo注册
     * @param stemName
     * @param stem
     */
    void newPojoRegisterIn(String stemName,Stem stem);

    /**
     * 不用的pojo注销
     * @param stemName
     */
    void uselessPojoRegisterOut(String stemName);

    /**
     * 兴奋pojo注册
     * @param stemName
     */
    void excitedPojoRegisterIn(String stemName);

    /**
     * 不再兴奋pojo注销
     * @param stemName
     */
    void unexcitedPojoRegisterOut(String stemName);


}

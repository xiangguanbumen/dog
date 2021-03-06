package com.ncell.wangcai.service.cns.main.physiology.pojo;

import com.ncell.wangcai.pojo.cns.main.stem.Stem;

/**
 * @author anliwei
 * @create 2020/6/8 19:26
 */
public interface PojoStateService {


    /**
     * pojo状态改变服务的主方法
     */
    void doPojoStateService();

    /**
     * 供外界调用的整体服务
     *  @param stem
     */
    void PojoStateChange(Stem stem);




    /**
     * 较接收到的消息和自身的element
     * @param stem
     * @return
     */
     Boolean compare(Stem stem);


    /**
     * 注册到细胞仓库
     * @param stem
     * @return
     */
    void registerPojo(Stem stem);

    


}

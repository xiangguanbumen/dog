package com.ncell.wangcai.service.cns.main.physiology;

import com.ncell.wangcai.pojo.cns.main.stem.Stem;

/**
 * @author anliwei
 * @create 2020/6/8 19:26
 */
public interface PojoStateService {
    /**
     * 较接收到的消息和自身的element
     * @param stem
     * @return
     */
     Boolean compare(Stem stem);


    /**
     * 发送到runningPojoCenter
     */
    void sendPojoOut();

    


}

package com.ncell.wangcai.service.cns.main.physiology.impl;

import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import com.ncell.wangcai.service.cns.main.physiology.PojoStateService;
import org.springframework.stereotype.Service;

/**
 *
 * 作用就是，找到兴奋pojo将它，发送到runningPojoCenter
 * 所有的发生改变的pojo都有机会得的stateservice，这个服务是普世性的。
 *
 *
 * @author anliwei
 * @create 2020/6/8 19:49
 */
@Service("pojoStateServiceImpl")
public class PojoStateServiceImpl implements PojoStateService {


    /**
     * 较接收到的消息和自身的element
     *
     * @param stem
     * @return
     */
    @Override
    public Boolean compare(Stem stem) {
        return null;
    }

    /**
     *将兴奋pojo发送到runningPojoCenter
     */
    @Override
    public void sendPojoOut() {

    }


}

package com.ncell.wangcai.service.cns.main.physiology.pojo.impl;

import com.ncell.wangcai.pojo.cns.main.*;
import com.ncell.wangcai.pojo.cns.main.runtime.RunningPojoCenter;
import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import com.ncell.wangcai.pojo.cns.main.warehouse.Warehouse;
import com.ncell.wangcai.service.cns.main.physiology.pojo.PojoStateService;
import com.ncell.wangcai.utils.cns.main.MessageUtil;
import com.ncell.wangcai.utils.cns.main.StemUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * 作用就是，找到兴奋pojo将它，发送到runningPojoCenter
 * 所有的发生改变的pojo都有机会得的stateservice，这个服务是普世性的。
 *
 * @author anliwei
 * @date 2020/6/8 19:49
 */
@Service("pojoStateServiceImpl")
@AllArgsConstructor
@Data
public class PojoStateServiceImpl implements PojoStateService {

    Warehouse warehouse;
    RunningPojoCenter runningPojoCenter;
    MessageUtil messageUtil;
    StemUtil stemUtil;

    /**
     * 供外界调用的整体服务
     */
    @Override
    public void doPojoStateService(Stem stem) {
        //如果pojo可以兴奋或已经兴奋，就发送到运行时
        if (this.compare(stem)) {
            this.sendPojoOut(stem);
        } else {

            //do nothing
        }
    }

    /**
     * 较接收到的消息和自身的element对比
     *
     * @param stem
     * @return
     */
    @Override
    public Boolean compare(Stem stem) {
        //如果细胞本身处于兴奋状态，直接输出true
        if (stem.getCurrentState() != 0) {
            return true;
        } else {
            //调用工具类判断消息是否有效，再判断数量，序列，位置是否一致，是否可以激活pojo
            return messageUtil.messageJudge(stem);
        }

    }

    /**
     * 将兴奋pojo发送到runningPojoCenter
     *  ConcurrentHashMap<String,Cell>调用put方法
     * 返回值：
     * （1）如果是新的记录，那么会向map中添加该键值对，并返回null。
     * （2）如果已经存在，那么不会覆盖已有的值，直接返回已经存在的值。
     * @return
     */
    @Override
    public void sendPojoOut(Stem stem) {
        String str1 = "cell";
        String str2 = "tissue";
        String str3 = "agent";
        String str4 = "scene";
        String str5 = "story";

        String stemName= stem.getName();

        if (stemName.contains(str1)) {
            warehouse.getCellWarehouse().getExcitedCell().put(stemName,(Cell)stem);
        } else if (stemName.contains(str2)) {
             warehouse.getTissueWarehouse().getAllTissue().put(stemName,(Tissue)stem);
        } else if (stemName.contains(str3)) {
            warehouse.getAgentWarehouse().getAllAgent().put(stemName,(Agent) stem);
        } else if (stemName.contains(str4)) {
             warehouse.getSceneWarehouse().getAllScene().put(stemName,(Scene) stem);
        } else if (stemName.contains(str5)) {
             warehouse.getStoryWarehouse().getAllStory().put(stemName,(Story) stem);
        }


    }


}

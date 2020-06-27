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

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Delayed;

/**
 * 1、细胞状态的改变服务，
 * 有四种可能
 * 静息状态到兴奋状态，
 * 兴奋状态到静息状态。
 * 静息状态维持，
 * 兴奋状态维持。
 * 2、细胞状态的注册服务
 * 注册进仓库中的兴奋结构，
 * 注册出仓库中的兴奋结构。
 *
 *
 *
 * 所有的发生改变的pojo都有机会得的stateservice，这个服务是普世性的。
 *
 * @update
 * 2020年6月26日16:20:32
 * 增加对已经兴奋细胞的状态服务
 * 需要增加时间判断因素，如果超过了固定阈值（细胞自身的属性中有，每个细胞的属性是不一样的），没有接收到新的消息，将状态设置为静息
 *
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
    PojoRegisterServiceImpl pojoRegisterService;

    /**
     * 供外界调用的整体服务
     */
    @Override
    public void doPojoStateService(Stem stem) {
        //todo 增加packagePojoStates服务用来处理像图片之类的一组pojo 的状态，  处理的结果放进，cellWarehouse中的ConcurrentLinkedQueue<ConcurrentLinkedQueue>  excitedCellPackageQueue

        //如果pojo已经兴奋，调用注册服务
        if(stem.getCurrentState()==1){
            pojoRegisterService.excitedPojoRegisterIn(stem.getName());
        }
        //如果经过输入信息和自身机构对比可以兴奋，调用注册服务
        else
        if (this.compare(stem)) {
            pojoRegisterService.excitedPojoRegisterIn(stem.getName());
        }
        //如果不能兴奋，什么也不做
        else {

            //do nothing
        }
    }

    /**
     * 较接收到的消息和自身的element对比
     *

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
     * @update
     * 2020年6月27日11:53:56
     * 注册服务，由专门的注册服务类提供，
     * 这里不再使用这个内部的注册方法。
     *
     * 将兴奋pojo发送到runningPojoCenter
     *  ConcurrentHashMap<String,Cell>调用put方法
     * 返回值：
     * （1）如果是新的记录，那么会向map中添加该键值对，并返回null。
     * （2）如果已经存在，那么不会覆盖已有的值，直接返回已经存在的值。
     * @return
     */
    @Override
    public void registerPojo(Stem stem) {
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

package com.ncell.wangcai.service.cns.main.physiology.impl;

import com.ncell.wangcai.pojo.cns.main.runtime.RunningMessageCenter;
import com.ncell.wangcai.pojo.cns.main.runtime.RunningPojoCenter;
import com.ncell.wangcai.pojo.cns.main.warehouse.Warehouse;
import com.ncell.wangcai.service.cns.main.physiology.PojoCreatService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * 创造新的pojo，这是最难的部分。
 * 到运行时中去找激活的pojo，没有目的地的消息
 * 组合成为新的pojo，这个pojo比组成他的最高的pojo高一级。
 *
 * @author anliwei
 * @Date 2020/6/11 20:35
 * @update 2020-6-15 20:36:29
 */
@Service("pojoCreatServiceImpl")
@Data
@AllArgsConstructor
public class PojoCreatServiceImpl implements PojoCreatService {

    Warehouse warehouse;
    RunningMessageCenter runningMessageCenter;
    RunningPojoCenter runningPojoCenter;



    /**
     * 总的方法
     */
    @Override
    public void doCreat() {

    }

    /**
     * 通过消息生产pojo
     * 将生成的pojo放到对应的仓库中
     */
    @Override
    public void creatPojoByMessage() {

    }

    /**
     * 通过已经兴奋的pojo生产pojo
     * 将生成的pojo放到对应的仓库中
     */
    @Override
    public void creatPojoByPojo() {

    }
}

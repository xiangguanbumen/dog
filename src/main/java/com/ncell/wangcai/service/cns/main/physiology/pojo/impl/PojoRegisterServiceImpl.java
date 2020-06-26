package com.ncell.wangcai.service.cns.main.physiology.pojo.impl;

import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import com.ncell.wangcai.pojo.cns.main.warehouse.Warehouse;
import com.ncell.wangcai.service.cns.main.physiology.pojo.PojoRegisterService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * pojo组成，注销服务类
 * 新生成pojo，新兴奋pojo注册
 * 无用pojo，不在兴奋pojo注销
 *
 * 说明，暂时不适用其他pojo类型，所有的pojo都使用cell表示
 *
 * @author anliwei
 * @Date 2020/6/26 23:09
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Service("pojoRegisterServiceImpl")
public class PojoRegisterServiceImpl implements PojoRegisterService {

    Warehouse warehouse;
    CellWarehouse cellWarehouse;

    /**
     * 提供注册服务
     */
    @Override
    public void doRegisterService() {

    }

    /**
     * 新生产的pojo注册
     *
     * @param stemName
     * @param stem
     */
    @Override
    public void newPojoRegisterIn(String stemName, Stem stem) {

    }

    /**
     * 不用的pojo注销
     *
     * @param stemName
     */
    @Override
    public void uselessPojoRegisterOut(String stemName) {

    }

    /**
     * 兴奋pojo注册
     *
     * @param stemName
     */
    @Override
    public void excitedPojoRegisterIn(String stemName) {

    }

    /**
     * 不再兴奋pojo注销
     *
     * @param stemName
     */
    @Override
    public void unexcitedPojoRegisterOut(String stemName) {

    }


}

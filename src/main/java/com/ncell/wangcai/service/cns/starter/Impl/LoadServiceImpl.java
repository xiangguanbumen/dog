package com.ncell.wangcai.service.cns.starter.Impl;

import com.ncell.wangcai.pojo.cns.main.Cell;
import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import com.ncell.wangcai.service.cns.starter.LoadService;
import com.ncell.wangcai.service.mapperService.impl.CellMapperServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * 系统load时，需要先加载各个实体类，然后再启动各种服务。
 * 需要注意的是，加载实体类是分步骤进行的， 第一步加载的是类的主体，第二步加载的是类的组成元素。
 * 因为组成元素不能单独存在，所有必须等待实体类主体加载完成才能进行。
 *
 * @update
 * 2020年6月27日16:45:21
 * 调整从启动器，改为装载，需要更高层的启动器调用
 *
 * @author anliwei
 * @create 2020/6/8 18:05
 */
@Service("loadServiceImpl")
@Data
@AllArgsConstructor
public class LoadServiceImpl implements LoadService {


    CellMapperServiceImpl cellMapperService;
    CellWarehouse cellWarehouse;

    /**
     * loadService主方法，调用其他pojo加载方法
     */
    @Override
    public void doLoadService() {
        this.loadCell();
        this.loadAgent();
        this.loadTissue();
        this.loadScene();
        this.loadStory();

    }


    /**
     * 加载pojo实体类的各种组成部分，如connection。message。element等
     */
    @Override
    public void loadPart(String name) {

        this.loadMessage(name);
        this.loadConnection(name);
        this.loadElement(name);
        this.loadElementCss(name);
        this.loadElementJs(name);

    }

    /**
     * 从数据库加载cell实例
     */
    @Override
    public void loadCell() {

        for (Stem stem : cellMapperService.findAllCell()) {

            cellWarehouse.getAllCell().put(stem.getName(),(Cell) stem);
            //如果细胞名称包含text，另外再存到textCell仓库中
            if(stem.getName().contains("text")){
                cellWarehouse.getTextCell().put(stem.getName(),(Cell) stem);
            }


        }

    }

    /**
     * 从数据库加载Tissue实例
     */
    @Override
    public void loadTissue() {

    }

    /**
     * 从数据库加载Agent实例
     */
    @Override
    public void loadAgent() {

    }

    /**
     * 从数据库加载Scene实例
     */
    @Override
    public void loadScene() {

    }

    /**
     * 从数据库加载Story实例
     */
    @Override
    public void loadStory() {

    }

    /**
     * 从数据库加载Connection到各个已经加载的实例
     *
     * @param name
     */
    @Override
    public void loadConnection(String name) {

    }

    /**
     * 从数据库加载Message到各个已经加载的实例
     *
     * @param name
     */
    @Override
    public void loadMessage(String name) {

    }

    /**
     * 从数据库加载Element到各个已经加载的实例
     *
     * @param name
     */
    @Override
    public void loadElement(String name) {

    }

    /**
     * 从数据库加载ElementCss到各个已经加载的实例
     *
     * @param name
     */
    @Override
    public void loadElementCss(String name) {

    }

    /**
     * 从数据库加载ElementJs到各个已经加载的实例
     *
     * @param name
     */
    @Override
    public void loadElementJs(String name) {

    }


}

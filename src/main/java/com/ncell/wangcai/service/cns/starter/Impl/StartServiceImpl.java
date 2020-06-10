package com.ncell.wangcai.service.cns.starter.Impl;

import com.ncell.wangcai.service.cns.starter.StartService;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * 系统start时，需要先加载各个实体类，然后再启动各种服务。
 * 需要注意的是，加载实体类是分步骤进行的， 第一步加载的是类的主体，第二步加载的是类的组成元素。
 * 因为组成元素不能单独存在，所有必须等待实体类主体加载完成才能进行。
 *
 * @author anliwei
 * @create 2020/6/8 18:05
 */
@Service("startServiceImpl")
@Data

public class StartServiceImpl implements StartService {


    @Override
    public void doStartService() {
        this.loadCell();
        this.loadAgent();
        this.loadTissue();
        this.loadScene();
        this.loadStory();

    }

    @Override
    public void loadStem() {
        //加载自身变量



        //加载组成类变量
        this.loadMessage();
        this.loadConnection();
        this.loadElement();
        this.loadElementCss();
        this.loadElementJs();


    }

    @Override
    public void loadCell() {
        this.loadStem();

    }

    @Override
    public void loadTissue() {
        this.loadStem();

    }

    @Override
    public void loadAgent() {
        this.loadStem();

    }

    @Override
    public void loadScene() {
        this.loadStem();

    }

    @Override
    public void loadStory() {
        this.loadStem();

    }

    @Override
    public void loadConnection() {

    }

    @Override
    public void loadMessage() {

    }

    @Override
    public void loadElement() {

    }

    @Override
    public void loadElementCss() {

    }

    @Override
    public void loadElementJs() {

    }
}

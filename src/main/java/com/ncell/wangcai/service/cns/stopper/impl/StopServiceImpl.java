package com.ncell.wangcai.service.cns.stopper.impl;

import com.ncell.wangcai.service.cns.stopper.StopService;

/**
 * @author anliwei
 * @create 2020/6/10 14:12
 */
public class StopServiceImpl implements StopService {
    @Override
    public void doStopService() {

        this.saveAgent();
        this.saveCell();
        this.saveTissue();
        this.saveScene();
        this.saveStory();


    }

    @Override
    public void saveStem() {
        //todo 存储pojo的自有变量实现


        //存储pojo的组成元素
        this.saveElement();
        this.saveElementCss();
        this.saveElementJs();
        this.saveConnection();
        this.saveMessage();
    }

    @Override
    public void saveCell() {
        this.saveStem();
    }

    @Override
    public void saveTissue() {
        this.saveStem();

    }

    @Override
    public void saveAgent() {
        this.saveStem();

    }

    @Override
    public void saveScene() {
        this.saveStem();

    }

    @Override
    public void saveStory() {
        this.saveStem();

    }

    @Override
    public void saveConnection() {


    }

    @Override
    public void saveMessage() {

    }

    @Override
    public void saveElement() {

    }

    @Override
    public void saveElementCss() {

    }

    @Override
    public void saveElementJs() {

    }
}

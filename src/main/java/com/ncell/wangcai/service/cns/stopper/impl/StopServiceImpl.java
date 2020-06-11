package com.ncell.wangcai.service.cns.stopper.impl;

import com.ncell.wangcai.pojo.cns.main.Cell;
import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import com.ncell.wangcai.service.cns.stopper.StopService;
import com.ncell.wangcai.service.mapperService.impl.CellMapperServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author anliwei
 * @create 2020/6/10 14:12
 */
@Service("stopServiceImpl")
@Data
@AllArgsConstructor
public class StopServiceImpl implements StopService {


    CellMapperServiceImpl cellService;

    CellWarehouse cellWarehouse;

    @Override
    public void doStopService() {


        //todo 增加判断数据库表格是否为空的语句
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

        for (Map.Entry<String, Cell> entry : cellWarehouse.getAllCell().entrySet()) {
            cellService.addCell(entry.getValue());
            }
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

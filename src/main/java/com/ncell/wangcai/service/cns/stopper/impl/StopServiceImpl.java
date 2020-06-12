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
    public void savePart() {

        //存储pojo的组成元素
        this.saveElement();
        this.saveElementCss();
        this.saveElementJs();
        this.saveConnection();
        this.saveMessage();
    }

    @Override
    public void saveCell() {

        //如果数据库cell_table中有数据，清空cell_table
        if(!cellService.findAllCell().isEmpty()){
            cellService.truncateTable();
            for (Map.Entry<String, Cell> entry : cellWarehouse.getAllCell().entrySet()) {
                cellService.addCell(entry.getValue());
            }
            this.savePart();
        }else{
        for (Map.Entry<String, Cell> entry : cellWarehouse.getAllCell().entrySet()) {
            cellService.addCell(entry.getValue());
            }
        this.savePart();
        }
    }

    @Override
    public void saveTissue() {
        this.savePart();

    }

    @Override
    public void saveAgent() {
        this.savePart();

    }

    @Override
    public void saveScene() {
        this.savePart();

    }

    @Override
    public void saveStory() {
        this.savePart();

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

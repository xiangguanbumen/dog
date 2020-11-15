package com.ncell.wangcai.serviceset.dogService.stopper.impl;

import com.ncell.wangcai.pojo.cns.main.base.Cell;
import com.ncell.wangcai.pojo.cns.main.part.Connection;
import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import com.ncell.wangcai.warehouse.product.CellWarehouse;
import com.ncell.wangcai.warehouse.product.ConnectionWarehouse;
import com.ncell.wangcai.serviceset.dogService.stopper.StopService;
import com.ncell.wangcai.service.mapperService.impl.CellMapperServiceImpl;
import com.ncell.wangcai.service.mapperService.impl.ConnectionMapperServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 保存到数据库。
 * 保存pojo实体类的时候，同时将其内部的connection等实体一并保存，
 * 这点与从数据库加载正好相反，
 * 因为如果此时不保存，保存connection实体的时候任然需要再次读取。
 * @update
 * 2020年7月3日22:12:53
 * connection也采用细胞的存储方式，全部存放到仓库中，细胞中只保留文字索引。
 *
 *
 * @author anliwei
 * @create 2020/6/10 14:12
 */
@Service("stopServiceImpl")
@Data
@AllArgsConstructor
public class StopServiceImpl implements StopService {


    CellMapperServiceImpl cellMapperService;
    ConnectionMapperServiceImpl connectionMapperService;

    CellWarehouse cellWarehouse;
    ConnectionWarehouse connectionWarehouse;

    @Override
    public void doStopService() {
        this.savePojo();

        this.savePart();
    }

    /**
     * 存储pojo实体
     */
    @Override
    public void savePojo() {
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
        if (!cellMapperService.findAllCell().isEmpty()) {
            cellMapperService.truncateTable();

            for (Map.Entry<String, Cell> entry : cellWarehouse.getAllCell().entrySet()) {
                Cell cell = entry.getValue();
                cellMapperService.addCell(cell);

            }

        } else {
            for (Map.Entry<String, Cell> entry : cellWarehouse.getAllCell().entrySet()) {
                Cell cell = entry.getValue();
                cellMapperService.addCell(cell);

            }
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

        //如果数据库connection_table中有数据，清空connection_table
        if (!connectionMapperService.findAllConnection().isEmpty()) {
            connectionMapperService.truncateTable();

            for (Map.Entry<String, Connection> entry : connectionWarehouse.getAllConnection().entrySet()) {
                Connection connection = entry.getValue();
                connectionMapperService.addConnection(connection);

            }

        } else {
            for (Map.Entry<String, Connection> entry : connectionWarehouse.getAllConnection().entrySet()) {
                Connection connection = entry.getValue();
                connectionMapperService.addConnection(connection);

            }
        }


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

    /**
     * 存储实体的组成部分
     *
     * @param stem
     */
    @Override
    public void savePart(Stem stem) {
        this.saveConnection(stem);
        this.saveElement(stem);
        this.saveElementCss(stem);
        this.saveElementJs(stem);
    }

    /**
     * 存储connection实体
     *
     * @param stem
     */
    @Override
    public void saveConnection(Stem stem) {

        //todo 暂时只保存输出的连接
        if(!stem.getConnectionsOutput().isEmpty()){

            for (String  connectionName:stem.getConnectionsOutput()
            ) {
                System.out.println(connectionName);
                Connection connection = connectionWarehouse.getAllConnection().get(connectionName);
                connectionMapperService.getConnectionMapper().addConnection(connection);

            }

        }





    }

    /**
     * 存储message实体
     *
     * @param stem
     */
    @Override
    public void saveMessage(Stem stem) {

    }

    /**
     * 存储element实体
     *
     * @param stem
     */
    @Override
    public void saveElement(Stem stem) {

    }

    /**
     * 存储elementCss实体
     *
     * @param stem
     */
    @Override
    public void saveElementCss(Stem stem) {

    }

    /**
     * 存储elementJs实体
     *
     * @param stem
     */
    @Override
    public void saveElementJs(Stem stem) {

    }
}

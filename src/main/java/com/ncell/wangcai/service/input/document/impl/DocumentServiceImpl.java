package com.ncell.wangcai.service.input.document.impl;

import com.ncell.wangcai.pojo.input.document.DocumentWarehouseModel;
import com.ncell.wangcai.pojo.input.document.NormalizedDocumentWarehouseModel;
import com.ncell.wangcai.service.input.document.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author anliwei
 * @Data 2020/6/6 13:02
 */
@Service("documentServiceImpl")
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentWarehouseModel documentWarehouseModel;
    @Autowired
    NormalizedDocumentWarehouseModel normalizedDocumentWarehouseModel;

    @Override
    public void doService(){
        this.obtainData();
        this.normalizeData();
        this.sendData();
    }

    @Override
    public void obtainData() {

    }

    public void obtainData(HttpServletRequest req) {

    }

    @Override
    public void normalizeData() {

    }

    @Override
    public void sendData() {

    }
}

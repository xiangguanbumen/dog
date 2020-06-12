package com.ncell.wangcai.service.input.document.impl;

import com.ncell.wangcai.pojo.input.document.DocumentWarehouse;
import com.ncell.wangcai.pojo.input.document.NormalizedDocumentWarehouse;
import com.ncell.wangcai.service.input.document.DocumentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author anliwei
 * @Data 2020/6/6 13:02
 */
@Service("documentServiceImpl")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentServiceImpl implements DocumentService {


    DocumentWarehouse documentWarehouse;
    NormalizedDocumentWarehouse normalizedDocumentWarehouse;

    @Override
    public void doService(){
        this.obtainData();
        this.normalizeData();
        this.sendData();
    }

    @Override
    public void obtainData() {

    }


    @Override
    public void normalizeData() {

    }

    @Override
    public void sendData() {

    }
}

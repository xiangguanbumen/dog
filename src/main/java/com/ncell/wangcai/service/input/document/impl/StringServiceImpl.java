package com.ncell.wangcai.service.input.document.impl;

import com.ncell.wangcai.pojo.input.document.DocumentWarehouse;
import com.ncell.wangcai.pojo.input.document.NormalizedDocument;
import com.ncell.wangcai.pojo.input.document.NormalizedDocumentWarehouse;
import com.ncell.wangcai.service.input.document.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author anliwei
 * @Data 2020/6/6 13:17
 */
@Service("StringServiceImpl")
public class StringServiceImpl implements StringService {

    String beforeNormalize;
    String afterNormalize;

    @Autowired
    DocumentWarehouse documentWarehouse;
    @Autowired
    NormalizedDocument normalizedDocument;
    @Autowired
    NormalizedDocumentWarehouse normalizedDocumentWarehouse;


    @Override
    public void obtainData() {

    }

    @Override
    /**
     * 标准化输入的文字。
     * 因为string字符串已经被过滤器标准化了，这里不需要做任何动作.
     * 只需要把流程走一遍即可
     */
    public void normalizeData() {

        beforeNormalize = documentWarehouse.getDocumentLinkedBlockingQueue().peek().getStringDocument();
        afterNormalize = beforeNormalize;
        normalizedDocument.setNormalizedDocument(afterNormalize);
    }

    @Override
    /**
     * 将处理好的字符串封装到NormalizedDocumentWarehouseModel
     */
    public void sendData() throws InterruptedException {
        normalizedDocumentWarehouse.getNormalizedDocumentLinkedBlockingQueue().put(normalizedDocument);
    }

    @Override
    public void doService() throws InterruptedException {
        this.obtainData();
        this.normalizeData();
        this.sendData();
    }


}

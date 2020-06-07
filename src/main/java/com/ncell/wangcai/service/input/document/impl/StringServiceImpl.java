package com.ncell.wangcai.service.input.document.impl;

import com.ncell.wangcai.pojo.input.document.DocumentWarehouseModel;
import com.ncell.wangcai.pojo.input.document.NormalizedDocumentModel;
import com.ncell.wangcai.pojo.input.document.NormalizedDocumentWarehouseModel;
import com.ncell.wangcai.service.input.document.StringService;
import com.ncell.wangcai.utils.ApplicationContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author anliwei
 * @Data 2020/6/6 13:17
 */
@Service("StringServiceImpl")
public class StringServiceImpl implements StringService {

    String beforeNormalize;
    String afterNormalize;

    @Autowired
    DocumentWarehouseModel documentWarehouseModel;
    @Autowired
    NormalizedDocumentModel normalizedDocumentModel;
    @Autowired
    NormalizedDocumentWarehouseModel normalizedDocumentWarehouseModel;


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

        beforeNormalize = documentWarehouseModel.getDocumentModelLinkedBlockingQueue().peek().getStringDocument();
        afterNormalize = beforeNormalize;
        normalizedDocumentModel.setNormalizedDocument(afterNormalize);
    }

    @Override
    /**
     * 将处理好的字符串封装到NormalizedDocumentWarehouseModel
     */
    public void sendData() throws InterruptedException {
        normalizedDocumentWarehouseModel.getNormalizedDocumentModeLinkedBlockingQueue().put(normalizedDocumentModel);
    }

    @Override
    public void doService() throws InterruptedException {
        this.obtainData();
        this.normalizeData();
        this.sendData();
    }


}

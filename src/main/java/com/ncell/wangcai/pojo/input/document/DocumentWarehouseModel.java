package com.ncell.wangcai.pojo.input.document;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author anliwei
 * @create 2020/6/4 12:39
 */
@Component("documentWarehouseModel")
public class DocumentWarehouseModel {

    /**
     * 使用阻塞链表，控制接收的文件数量，文档文件问题不大，但是视频图象文档要注意控制缓存大小
     */
    List<DocumentModel> documentModelList;

    public DocumentWarehouseModel() {
    }

    public List<DocumentModel> getDocumentModelList() {
        return documentModelList;
    }

    public void setDocumentModelList(List<DocumentModel> documentModelList) {
        this.documentModelList = documentModelList;
    }
}

package com.ncell.wangcai.pojo.input.document;

import org.springframework.stereotype.Component;

/**
 * @author anliwei
 * @create 2020/6/4 10:16
 */
@Component
public class NormalizedDocumentModel {

    String normalizedDocument;

    public NormalizedDocumentModel() {
    }

    public NormalizedDocumentModel(String normalizedDocument) {
        this.normalizedDocument = normalizedDocument;
    }

    public String getNormalizedDocument() {
        return normalizedDocument;
    }

    public void setNormalizedDocument(String normalizedDocument) {
        this.normalizedDocument = normalizedDocument;
    }
}

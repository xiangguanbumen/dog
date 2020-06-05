package com.ncell.wangcai.pojo.input.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author anliwei
 * @create 2020/6/4 9:06
 */
@Component("documentModel")
public class DocumentModel {

    //需要引入poi相关资料，进行Word，Excel等格式的解析,
    /**
     * 接收Word格式文档文件
     */
    Object word=null;

    /**
     * 接收Excel格式文档文件
     */
    Object excel=null;
    /**
     * 接收PPT格式文档文件
     */
    Object ppt=null;
    /**
     * 接收txt格式文档文件
     */
    Object txt=null;

    /**
     * 接收string格式文档文件
     */

    String  stringDocument=null;


    String docNanme="doc文件名称";



    public String getDocNanme() {
        return docNanme;
    }

    public void setDocNanme(String docNanme) {
        this.docNanme = docNanme;
    }

    public DocumentModel() {

    }
    public DocumentModel(String docNanme) {
        this.docNanme = docNanme;
    }

    public Object getWord() {
        return word;
    }

    public void setWord(Object word) {
        this.word = word;
    }

    public Object getExcel() {
        return excel;
    }

    public void setExcel(Object excel) {
        this.excel = excel;
    }

    public Object getPpt() {
        return ppt;
    }

    public void setPpt(Object ppt) {
        this.ppt = ppt;
    }

    public Object getTxt() {
        return txt;
    }

    public void setTxt(Object txt) {
        this.txt = txt;
    }

    public String getStringDocument() {
        return stringDocument;
    }

    public void setStringDocument(String stringDocument) {
        this.stringDocument = stringDocument;
    }
}

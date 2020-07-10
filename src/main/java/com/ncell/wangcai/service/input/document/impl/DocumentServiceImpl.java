package com.ncell.wangcai.service.input.document.impl;

import com.ncell.wangcai.pojo.input.document.DocumentWarehouse;
import com.ncell.wangcai.pojo.input.document.NormalizedDocumentWarehouse;
import com.ncell.wangcai.service.input.document.DocumentService;
import com.ncell.wangcai.utils.learn.ExcelUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

import static org.apache.poi.poifs.macros.Module.ModuleType.Document;

/**
 *
 *
 * @author anliwei
 * @Date 2020/6/6 13:02
 * @update 2020-7-10 12:19:43
 */
@Service("documentServiceImpl")
@AllArgsConstructor
@Data
public class DocumentServiceImpl implements DocumentService {


    DocumentWarehouse documentWarehouse;
    NormalizedDocumentWarehouse normalizedDocumentWarehouse;

    ExcelUnit excelUnit;

    /**
     * 笼统的流程，废弃了
     */
    @Override
    public void doService(){
        this.obtainData();
        this.normalizeData();
        this.sendData();
    }

    /**
     * 本地文档服务
     */
    @Override
    public void doLocalDocumentService() {
        this.obtainLocalDocument();
        this.normalizeData();
        this.sendData();

    }

    /**
     * 网络文档服务
     */
    @Override
    public void doWebDocumentService() {

        this.obtainWebDocument();
        this.normalizeData();
        this.sendData();
    }

    /**
     * 用户输入文档服务
     */
    @Override
    public void doUserInputDocumentService() {

        this.obtainUserInputDocument();
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

    /**
     * 获取本地文档（指定的本地文件夹）
     * 这里暂时使用绝对路径
     * c://ncell//doc
     * 该路径下面分为三个文件夹，分别存放word，excel，ppt文件
     * 主要是用作系统训练时使用。
     */
    @Override
    public void obtainLocalDocument() {

        //获取word文件夹
        File wordDir = new File("c://ncell//doc//word");

        //获取excel文件夹
        File excelDir = new File("c://ncell//doc//excel");

        File excelFile = new File("c://ncell//doc//excel//词频表.xsl");

        while(excelDir.listFiles().length>0){
            for (File file:excelDir.listFiles()
            ) {
                try {

                    System.out.println("file name "+file.getName());
                    excelUnit.readExcelCell(file);
                    file.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }}


        //获取ppt文件夹
        File pptlDir = new File("c://ncell//doc//ppt");

    }

    /**
     * 获取web文档
     * 可以是生产环境用户指定，也可以是系统训练
     */
    @Override
    public void obtainWebDocument() {

    }

    /**
     * 获取用户输入文档（也是一个固定的用户上传文档的存储文件夹）
     * 主要是用作生产环境
     */
    @Override
    public void obtainUserInputDocument() {

    }
}

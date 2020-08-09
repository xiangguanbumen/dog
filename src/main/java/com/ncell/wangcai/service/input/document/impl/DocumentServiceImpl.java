package com.ncell.wangcai.service.input.document.impl;

import com.ncell.wangcai.pojo.input.document.Document;
import com.ncell.wangcai.pojo.input.document.DocumentWarehouse;
import com.ncell.wangcai.pojo.input.document.NormalizedDocument;
import com.ncell.wangcai.pojo.input.document.NormalizedDocumentWarehouse;
import com.ncell.wangcai.service.input.document.DocumentService;
import com.ncell.wangcai.utils.input.document.ExcelUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * 文档输入标化化类，将各种类型文档文件转换成标准的string文件
 * 目前还不能识别文档中的各种格式，
 * 下一次迭代的时候将各种文档标准化的同时，
 * 全部转换为图像格式。
 * 便于识别文档中的各种文字格式
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
     * 所有的服务集合到一起
     */
    @Override
    public void doService() {
        this.doLocalDocumentService();

    }

    /**
     * 本地文档服务
     */
    @Override
    public void doLocalDocumentService() {
        this.obtainLocalDocument();
        this.normalizeLocalDocument();


    }

    /**
     * 网络文档服务
     */
    @Override
    public void doWebDocumentService() {

        this.obtainWebDocument();
        this.normalizeData();

    }

    /**
     * 用户输入文档服务
     */
    @Override
    public void doUserInputDocumentService() {

        this.obtainUserInputDocument();
        this.normalizeData();

    }

    @Override
    public void obtainData() {

    }


    /**
     * 获取本地文档（指定的本地文件夹）
     * 这里暂时使用绝对路径
     * c://ncell//doc
     * 该路径下面分为三个文件夹，分别存放word，excel，ppt文件
     * 主要是用作系统训练时使用。
     *
     * @update 2020年7月18日20:27:00
     * <p>
     * 路径下增加html文件夹，upload文件夹等，用来存储不同的文档
     * 改变使用目的，不仅仅是训练时使用，平时也作为缓存使用。
     */
    @Override
    public void obtainLocalDocument() {

        //获取word文件夹
        File wordDir = new File("c://ncell//doc//word");

        while (wordDir.listFiles().length > 0) {
            for (File file : wordDir.listFiles()
            ) {
                try {

                    System.out.println("正在读取 ： " + file.getName());
                    //读取完成后将文件删除
                    //file.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }

        //获取excel文件夹
        File excelDir = new File("c://ncell//doc//excel");

        //File excelFile = new File("c://ncell//doc//excel//词频表.xsl");

        while (excelDir.listFiles().length > 0) {
            for (File file : excelDir.listFiles()
            ) {
                try {

                    System.out.println("正在读取 ： " + file.getName());
                    //主要方法
                    //将文件中的信息存放到输入信息仓库
                    excelUnit.readExcelCell(file);
                    file.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }


        //获取ppt文件夹
        File pptDir = new File("c://ncell//doc//ppt");

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

    /**
     * 标准化数据
     */
    @Override
    public void normalizeData() {

    }

    /**
     * 标准化本地文档数据
     * <p>
     * 偷懒，先原样不变给后面
     */
    @Override
    public void normalizeLocalDocument() {
        String beforeNormalize=null;
       // String afterNormalize;
        while (!documentWarehouse.getDocumentLinkedBlockingQueue().isEmpty()) {
            try {
                Document document = documentWarehouse.getDocumentLinkedBlockingQueue().take();
                /**
                 * 注意：这里是一个坑，
                 * document类不仅包含excelCell。wordParagraph，还有stringDocument
                 * 一定要分类别处理
                 */
                if(document.getExcelCell()!=null){beforeNormalize = document.getExcelCell();}
                else if(document.getStringDocument()!=null){
                    beforeNormalize = document.getStringDocument();
                }
                else if(document.getWordParagraph()!=null){

                }

                if (beforeNormalize != null) {
                    String afterNormalize = beforeNormalize;

                    System.out.println("标准化 " + afterNormalize);

                    //新建非常关键，如果不新建存储的只是一个索引，重新赋值后会改变刚存储的值。
                    NormalizedDocument normalizedDocument = new NormalizedDocument();
                    normalizedDocument.setNormalizedDocument(afterNormalize);
                    this.sendData(normalizedDocument);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }


    }

    /**
     * 标准化网络文档数据
     */
    @Override
    public void normalizeWebDocument() {

    }

    /**
     * 标准化用户输入文档数据
     */
    @Override
    public void normalizeUserInputDocument() {

    }

    /**
     * 发送数据
     * 2020年6月7日00:01:32
     * 以后将程序部署为分布式，在使用restfull编码，每一个都对应一个接口，目前只是分层，没有分布。
     * 不需要senddata，高层来低层的仓库取数据就可以了
     */
    @Override
    public void sendData(NormalizedDocument normalizedDocument) {

        try {
            if (normalizedDocument.getNormalizedDocument() != null) {
                normalizedDocumentWarehouse.getNormalizedDocumentLinkedBlockingQueue().put(normalizedDocument);

               // System.out.println("将标准化后的 " + normalizedDocument.getNormalizedDocument() + " 放进标准化仓库");

                //将标准化后文档设置为空,这是还不能清空，因为索引还没有变更，清空会清空仓库中数据
                // normalizedDocument.setNormalizedDocument(null);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

package com.ncell.wangcai.serviceset.trainservice.locallearn.impl;

import com.ncell.wangcai.pojo.cns.main.warehouse.Warehouse;
import com.ncell.wangcai.service.input.document.impl.DocumentServiceImpl;
import com.ncell.wangcai.serviceset.dogService.loader.impl.LoadServiceImpl;
import com.ncell.wangcai.serviceset.dogService.threadFactory.MyThreadFactory;
import com.ncell.wangcai.serviceset.trainservice.locallearn.LocalLearnService;
import com.ncell.wangcai.utils.input.document.ExcelUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author anliwei
 * @Date 2020/7/9 15:28
 */
@AllArgsConstructor
@Data
@Service("localLearnServiceImpl")
public class LocalLearnServiceImpl implements LocalLearnService {

     Warehouse warehouse;
    ExcelUnit excelUnit;
    //JFileChooser jFileChooser;

    LoadServiceImpl loadService;

    MyThreadFactory myThreadFactory;

    LocalLearnServiceImpl localLearnService;

    DocumentServiceImpl documentService;




    /**
     * 创建并行处理服务
     */
    public void doRunningService(){



        myThreadFactory.getPool().execute(new Runnable() {
            @Override
            public void run() {
                //1.读取doc
                learnDoc();

            }
        });

        myThreadFactory.getPool().execute(new Runnable() {
            @Override
            public void run() {
                //
                learnImage();

            }
        });
        myThreadFactory.getPool().execute(new Runnable() {
            @Override
            public void run() {
                learnSound();

            }
        });
        myThreadFactory.getPool().execute(new Runnable() {
            @Override
            public void run() {
                learnVideo();
            }
        });

    }

    /**
     * 文档学习
     *
     */
    @Override
    public void learnDoc() {


        File dir = new File("c://ncell//doc//excel");
        if(dir.listFiles().length>0){
        for (File file:dir.listFiles()
             ) {
            try {
                excelUnit.readExcelCell(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            file.delete();

        }}

    }

    /**
     * 声音学习
     *
     * @param file
     */
    @Override
    public void learnSound(File file) {

    }

    /**
     * 图像学习
     *
     * @param file
     */
    @Override
    public void learnImage(File file) {

    }

    /**
     * 视频学习
     *
     * @param file
     */
    @Override
    public void learnVideo(File file) {

    }

    /**
     * 声音学习
     */
    @Override
    public void learnSound() {
        /*while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("learn sound ");

        }*/


    }

    /**
     * 图像学习
     */
    @Override
    public void learnImage() {

       /* while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("learn image ");

        }*/


    }

    /**
     * 视频学习
     */
    @Override
    public void learnVideo() {

        /*while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("learn video ");

        }*/



    }
}

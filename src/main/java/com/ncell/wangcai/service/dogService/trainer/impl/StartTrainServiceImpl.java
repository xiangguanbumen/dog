package com.ncell.wangcai.service.dogService.trainer.impl;

import com.ncell.wangcai.service.dogService.loader.impl.LoadServiceImpl;
import com.ncell.wangcai.service.dogService.trainer.StartTrainService;
import com.ncell.wangcai.service.dogService.threadFactory.MyThreadFactory;
import com.ncell.wangcai.service.input.document.impl.DocumentServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import static java.lang.Thread.sleep;

/**
 * @author anliwei
 * @Date 2020/7/9 15:55
 */
@Service("startTrainServiceImpl")
@Data
@AllArgsConstructor
public class StartTrainServiceImpl implements StartTrainService {

    LoadServiceImpl loadService;

    MyThreadFactory myThreadFactory;

    LocalLearnServiceImpl localLearnService;

    DocumentServiceImpl documentService;
    /**
     * 开启startTrain服务
     */
    @Override
    public void doStartTrainService() {

            doRunningService();

    }

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
     */
    @Override
    public void learnDoc() {

        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           // System.out.println("learn doc 从本地文件夹读取信息");
            documentService.doLocalDocumentService();

            }
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

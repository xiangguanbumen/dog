package com.ncell.wangcai.service.dogService.manager.impl;

import com.ncell.wangcai.pojo.assistant.indicator.CnsIndicator;
import com.ncell.wangcai.pojo.assistant.indicator.InputIndicator;
import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import com.ncell.wangcai.pojo.input.document.DocumentWarehouse;
import com.ncell.wangcai.pojo.input.document.NormalizedDocumentWarehouse;
import com.ncell.wangcai.pojo.input.image.ImageWarehouse;
import com.ncell.wangcai.pojo.input.image.NormalizedImageWarehouse;
import com.ncell.wangcai.pojo.input.sound.NormalizedSoundWarehouse;
import com.ncell.wangcai.pojo.input.sound.SoundWarehouse;
import com.ncell.wangcai.pojo.input.video.NormalizedVideoWarehouse;
import com.ncell.wangcai.pojo.input.video.VideoWarehouse;
import com.ncell.wangcai.service.dogService.manager.ManagerService;
import com.ncell.wangcai.service.dogService.threadFactory.MyThreadFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * 管家服务
 * 一是获取系统状态
 * 二是根据不同系统状态调用不同服务
 *
 * @author anliwei
 * @Date 2020/7/16 17:42
 */
@Service("managerServiceImpl")
@AllArgsConstructor
@Data
public class ManagerServiceImpl implements ManagerService {

    MyThreadFactory myThreadFactory;

    InputIndicator inputIndicator;
    CnsIndicator cnsIndicator;


    /**
     * 获取输入状态需要的类
     */
    DocumentWarehouse documentWarehouse;
    NormalizedDocumentWarehouse normalizedDocumentWarehouse;
    ImageWarehouse imageWarehouse;
    NormalizedImageWarehouse normalizedImageWarehouse;
    SoundWarehouse soundWarehouse;
    NormalizedSoundWarehouse normalizedSoundWarehouse;
    VideoWarehouse videoWarehouse;
    NormalizedVideoWarehouse normalizedVideoWarehouse;


    /**
     * 获取cns状态需要的类
     */
    CellWarehouse cellWarehouse;






    public void doService(){

        //启动获取状态进程
        myThreadFactory.getPool().execute(new Runnable() {
            @Override
            public void run() {
                obtainSystemState();
            }
        });

        //启动激活进展，根据状态激活不同进程
        myThreadFactory.getPool().execute(new Runnable() {
            @Override
            public void run() {
                invokeOtherService();
            }
        });

    }

    /**
     * 获取系统状态，将状态值写入
     * indicator
     */
    @Override
    public void obtainSystemState() {

        //更新输入文件夹的信息
        this.updateInputFileState();

        //根据标准化前仓库信息修改inputIndicator的值
        inputIndicator.setDocumentWarehouseState(documentWarehouse.getDocumentLinkedBlockingQueue().size());
        inputIndicator.setImageWarehouseState(imageWarehouse.getImageLinkedBlockingQueue().size());
        inputIndicator.setSoundWarehouseState(soundWarehouse.getSoundLinkedBlockingQueue().size());
        inputIndicator.setVideoWarehouseState(videoWarehouse.getVideoLinkedBlockingQueue().size());

        //根据标准化后仓库信息修改inputIndicator的值
        inputIndicator.setNormalizedDocumentWarehouseState(normalizedDocumentWarehouse.getNormalizedDocumentLinkedBlockingQueue().size());
        inputIndicator.setNormalizedImageWarehouseState(normalizedImageWarehouse.getNormalizedImageLinkedBlockingQueue().size());
        inputIndicator.setNormalizedSoundWarehouseState(normalizedSoundWarehouse.getNormalizedSoundLinkedBlockingQueue().size());
        inputIndicator.setNormalizedVideoWarehouseState(normalizedVideoWarehouse.getNormalizedVideoLinkedBlockingQueue().size());





    }

    /**
     * 读取indicator中系统状态值
     * 根据各种状态值，创建不停的进程，关闭不同的进程
     */
    @Override
    public void invokeOtherService() {
        System.out.println(inputIndicator.getExcelFileFolderState());


    }

    void updateInputFileState(){


        //todo 其他类型文档的读取等需要时再补充
        //todo 不停的打开文件会不会占用大量资源？

        //获取word文件夹
        File wordFileFolder = new File("c://ncell//doc//word");

        //获取excel文件夹
        File excelFileFolder = new File("c://ncell//doc//excel");

        if(wordFileFolder.exists()){
            inputIndicator.setWordFileFolderState(wordFileFolder.list().length);
        }

        if(excelFileFolder.exists()){
            inputIndicator.setExcelFileFolderState(excelFileFolder.listFiles().length);
           /* for (File ff:excelFileFolder.listFiles()) {
                System.out.println(ff);
            }*/

        }



    }
}

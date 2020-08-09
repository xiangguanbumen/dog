package com.ncell.wangcai.serviceset.dogService.manager.impl;

import com.ncell.wangcai.pojo.assistant.indicator.CnsIndicator;
import com.ncell.wangcai.pojo.assistant.indicator.InputIndicator;
import com.ncell.wangcai.pojo.assistant.indicator.OutputIndicator;
import com.ncell.wangcai.pojo.assistant.indicator.ServiceIndicator;
import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import com.ncell.wangcai.pojo.input.document.DocumentWarehouse;
import com.ncell.wangcai.pojo.input.document.NormalizedDocumentWarehouse;
import com.ncell.wangcai.pojo.input.image.ImageWarehouse;
import com.ncell.wangcai.pojo.input.image.NormalizedImageWarehouse;
import com.ncell.wangcai.pojo.input.sound.NormalizedSoundWarehouse;
import com.ncell.wangcai.pojo.input.sound.SoundWarehouse;
import com.ncell.wangcai.pojo.input.video.NormalizedVideoWarehouse;
import com.ncell.wangcai.pojo.input.video.VideoWarehouse;
import com.ncell.wangcai.serviceset.dogService.manager.ManagerService;
import com.ncell.wangcai.serviceset.dogService.threadFactory.MyThreadFactory;
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
    OutputIndicator outputIndicator;

    ServiceIndicator serviceIndicator;


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



                obtainSystemStateAndUpdateIndicator();
            }
        });
        //将线程名称注册到线程表中。
        myThreadFactory.getThreadNameHashMap().put("obtainSystemState",Thread.currentThread().getName());


        //启动激活进展，根据状态激活不同进程
        myThreadFactory.getPool().execute(new Runnable() {
            @Override
            public void run() {



                startAndSleepOtherService();

            }
        });

        //将线程名称注册到线程表中。
        myThreadFactory.getThreadNameHashMap().put("invokeOtherService",Thread.currentThread().getName());

    }

    /**
     * 获取系统状态，将状态值写入
     * indicator
     */
    @Override
    public void obtainSystemStateAndUpdateIndicator() {

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


        //根据细胞仓库中的信息修改cnsIndicator的值

        cnsIndicator.setAllCellState(cellWarehouse.getAllCell().size());

        //获取输入转换后的各类细胞信息并修改cnsIndicator的值
        cnsIndicator.setInputImageCellListQueueState(cellWarehouse.getInputImageCellListQueue().size());
        cnsIndicator.setInputSoundCellListQueueState(cellWarehouse.getInputSoundCellListQueue().size());
        cnsIndicator.setInputTextCellListQueueState(cellWarehouse.getInputTextCellListQueue().size());
        cnsIndicator.setInputVideoCellListQueueState(cellWarehouse.getInputVideoCellListQueue().size());

        //获取兴奋细胞信息并修改cnsIndicator的值
        cnsIndicator.setExcitedCellState(cellWarehouse.getExcitedCell().size());
        //获取部分兴奋细胞信息并修改cnsIndicator的值
        cnsIndicator.setPartExcitedCellState(cellWarehouse.getPartExcitedCell().size());
        //获取兴奋队列信息并修改cnsIndicator的值
        cnsIndicator.setExcitedCellQueueState(cellWarehouse.getExcitedCellQueue().size());
        cnsIndicator.setExcitedCellQueueForGenerateNewCellState(cellWarehouse.getExcitedCellQueueForGenerateNewCell().size());
        cnsIndicator.setExcitedCellQueueForSendMessageState(cellWarehouse.getExcitedCellQueueForSendMessage().size());
        cnsIndicator.setExcitedCellQueueForStateServiceState(cellWarehouse.getExcitedCellQueueForStateService().size());
        //获取兴奋细胞组信息并修改cnsIndicator的值
        cnsIndicator.setGroupExcitedCellState(cellWarehouse.getGroupExcitedCell().size());

        //获取各种方法分组后信息并修改cnsIndicator的值
        //获取图像颜色分组信息并修改cnsIndicator的值
        cnsIndicator.setPojoGroupByColorRedState(cellWarehouse.getPojoGroupByColorRed().size());
        cnsIndicator.setPojoGroupByColorGreenState(cellWarehouse.getPojoGroupByColorGreen().size());
        cnsIndicator.setPojoGroupByColorBlueState(cellWarehouse.getPojoGroupByColorBlue().size());
        cnsIndicator.setPojoGroupByColorGrayState(cellWarehouse.getPojoGroupByColorGray().size());
        //获取声音分组信息并修改cnsIndicator的值
        cnsIndicator.setPojoGroupBySoundFrequencyState(cellWarehouse.getPojoGroupByConnectionFrequency().size());
        cnsIndicator.setPojoGroupBySoundVolumeState(cellWarehouse.getPojoGroupBySoundVolume().size());
        //获取连接分组信息并修改cnsIndicator的值
        cnsIndicator.setPojoGroupByConnectionFrequencyState(cellWarehouse.getPojoGroupByConnectionFrequency().size());
        cnsIndicator.setPojoGroupByConnectionStrengthState(cellWarehouse.getPojoGroupByConnectionStrength().size());
        //获取空间分组信息并修改cnsIndicator的值
        cnsIndicator.setPojoGroupBySpaceState(cellWarehouse.getPojoGroupBySpace().size());
        //获取时间分组信息并修改cnsIndicator的值
        cnsIndicator.setPojoGroupByTimeState(cellWarehouse.getPojoGroupByTime().size());

        //获取各种实体类信息并修改cnsIndicator的值
        cnsIndicator.setAllCellState(cellWarehouse.getAllCell().size());
        cnsIndicator.setTextCellState(cellWarehouse.getTextCell().size());
        cnsIndicator.setImageCellState(cellWarehouse.getImageCell().size());
        cnsIndicator.setSoundCellState(cellWarehouse.getSoundCell().size());
        cnsIndicator.setDirectionCellState(cellWarehouse.getDirectionCell().size());
        cnsIndicator.setSpanCellState(cellWarehouse.getSpanCell().size());
        cnsIndicator.setSequenceCellState(cellWarehouse.getSequenceCell().size());
        cnsIndicator.setIntervalCellState(cellWarehouse.getIntervalCell().size());



        //获取服务状态信息并修改serviceIndicator的值

        serviceIndicator.setThreadNameHashMapState(myThreadFactory.getThreadNameHashMap().size());







    }

    /**
     * 读取indicator中系统状态值
     * 根据各种状态值，创建不同的进程，关闭不同的进程
     *
     * @update
     * 2020年7月18日17:18:46
     * 判断路径太多，
     * 线程控制太复杂，还是退回到原来的思路，
     * 同时启动，让系统来调度线程的运行
     */
    @Override
    public void startAndSleepOtherService() {


        /**
         * 如果excel输入文件夹中有文件，且读取excel的进程没有创建，则创建新的线程并注册到线程名称表
         * 如果excel输入文件夹中有文件，且读取excel的进程已经创建，则查看线程状态
         * 如果sleep唤醒，如果执行，继续执行
         * 如果excel输入文件夹中没有文件，且读取excel的进程没有创建，则什么也不做
         * 如果excel输入文件夹中没有文件，且读取excel的进程已经创建，则查看线程状态
         * 如果sleep，继续sleep，如果执行则，sleep
         */




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
            inputIndicator.setDocumentFileFolderState(wordFileFolder.list().length);
        }

        if(excelFileFolder.exists()){
            inputIndicator.setExcelFileFolderState(excelFileFolder.listFiles().length);
            inputIndicator.setDocumentFileFolderState(inputIndicator.getDocumentFileFolderState()+excelFileFolder.listFiles().length);


        }



    }
}

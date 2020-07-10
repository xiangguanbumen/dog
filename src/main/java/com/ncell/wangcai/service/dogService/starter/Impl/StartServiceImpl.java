package com.ncell.wangcai.service.dogService.starter.Impl;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import com.ncell.wangcai.pojo.cns.main.warehouse.MessageWarehouse;
import com.ncell.wangcai.pojo.input.document.NormalizedDocumentWarehouse;
import com.ncell.wangcai.service.cns.inputConverter.impl.DocumentToCellConvertServiceImpl;
import com.ncell.wangcai.service.cns.main.physiology.message.impl.MessageSendServiceImpl;
import com.ncell.wangcai.service.cns.main.physiology.pojo.impl.PojoCreatServiceImpl;
import com.ncell.wangcai.service.cns.main.physiology.pojo.impl.PojoImpulseServiceImpl;
import com.ncell.wangcai.service.cns.main.physiology.pojo.impl.PojoStateServiceImpl;
import com.ncell.wangcai.service.dogService.loader.impl.LoadServiceImpl;
import com.ncell.wangcai.service.dogService.starter.StartService;
import com.ncell.wangcai.service.dogService.threadFactory.MyThreadFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

/**
 * @author anliwei
 * @Date 2020/6/27 16:44
 */
@AllArgsConstructor
@Data
@Service("startServiceImpl")
public class StartServiceImpl implements StartService {


    CellWarehouse cellWarehouse;
    MessageWarehouse messageWarehouse;
    NormalizedDocumentWarehouse normalizedDocumentWarehouse;

    PojoCreatServiceImpl pojoCreatService;
    PojoImpulseServiceImpl pojoImpulseService;
    PojoStateServiceImpl pojoStateService;

    MessageSendServiceImpl messageSendService;

    LoadServiceImpl loadService;

    MyThreadFactory myThreadFactory;

    DocumentToCellConvertServiceImpl documentToCellConvertService;


    @Override
    public void doStartService() {

        doRunningService();
    }

    /**
     * 使用并发启动各种服务，
     */
    public void doRunningService() {

        /**
         * 创建新的pojo
         * 发送消息
         * 确定pojo状态
         * 将输入信息转换成细胞
         * 四个进程同时进行
         */
        myThreadFactory.getPool().execute(new Runnable() {
            @Override
            public void run() {
                //1.创建新的pojo服务
                createPojo();

            }
        });
        myThreadFactory.getPool().execute(new Runnable() {
            @Override
            public void run() {
                //2.发送信息
                releaseImpulse();

            }
        });
        myThreadFactory.getPool().execute(new Runnable() {
            @Override
            public void run() {
                //3.改变状态
                changeState();

            }
        });
        myThreadFactory.getPool().execute(new Runnable() {
            @Override
            public void run() {
                //4.消息发送
                sendMessage();

            }
        });

        myThreadFactory.getPool().execute(new Runnable() {
            @Override
            public void run() {
                //转换细胞
                convertInput();

            }
        });

    }


    /**
     * 生成新的pojo，根据兴奋细胞组合
     */
    @Override
    public void createPojo()  {
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("create pojo");
            //如果兴奋队列不为空，也就是有细胞处于兴奋状态
            while (!cellWarehouse.getExcitedCellQueueForGenerateNewCell().isEmpty()) {
                pojoCreatService.doCreatService();


            }
        }

    }

    /**
     * 发送神经冲动，产生消息（但是只是发送到消息仓库）
     */
    @Override
    public void releaseImpulse()  {
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("impulse ");
            //如果兴奋队列不为空，也就是有细胞处于兴奋状态
            while (!cellWarehouse.getExcitedCellQueueForSendMessage().isEmpty()) {
                pojoImpulseService.doPojoImpulseService();

            }
        }
    }

    /**
     * 根据收到的消息决定细胞的状态
     */
    @Override
    public void changeState()  {
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           // System.out.println("change state");
            //如果接受到消息的细胞队列不为空，也就是有细胞处于部分兴奋状态
            while (!cellWarehouse.getPartExcitedCell().isEmpty()) {
                pojoStateService.doPojoStateService();


            }
        }

    }

    /**
     * 发送消息到具体目标细胞
     */
    @Override
    public void sendMessage()  {
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("send message");
            //如果消息仓库中消息队列不为空
            while (!messageWarehouse.getMessageQueue().isEmpty()) {
                messageSendService.doSendMessageService();

            }
        }

    }

    /**
     * 获取输入，输入标准化
     */
    @Override
    public void getInput() {
        //学习程序已经发送到输入仓库
    }

    /**
     * 转换输入成细胞
     */
    @Override
    public void convertInput()  {
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

           // System.out.println("转换输入文档");
            while (!normalizedDocumentWarehouse.getNormalizedDocumentLinkedBlockingQueue().isEmpty()) {
            }
            try {
                documentToCellConvertService.doService();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
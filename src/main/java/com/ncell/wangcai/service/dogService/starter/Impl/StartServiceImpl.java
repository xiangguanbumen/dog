package com.ncell.wangcai.service.dogService.starter.Impl;

import com.ncell.wangcai.pojo.assistant.indicator.CnsIndicator;
import com.ncell.wangcai.pojo.assistant.indicator.InputIndicator;
import com.ncell.wangcai.pojo.assistant.indicator.ServiceIndicator;
import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import com.ncell.wangcai.pojo.cns.main.warehouse.MessageWarehouse;
import com.ncell.wangcai.pojo.input.document.DocumentWarehouse;
import com.ncell.wangcai.pojo.input.document.NormalizedDocumentWarehouse;
import com.ncell.wangcai.service.cns.inputConverter.impl.DocumentToCellConvertServiceImpl;
import com.ncell.wangcai.service.cns.main.physiology.message.impl.MessageSendServiceImpl;
import com.ncell.wangcai.service.cns.main.physiology.pojo.impl.PojoCreatServiceImpl;
import com.ncell.wangcai.service.cns.main.physiology.pojo.impl.PojoImpulseServiceImpl;
import com.ncell.wangcai.service.cns.main.physiology.pojo.impl.PojoStateServiceImpl;
import com.ncell.wangcai.service.dogService.loader.impl.LoadServiceImpl;
import com.ncell.wangcai.service.dogService.manager.impl.ManagerServiceImpl;
import com.ncell.wangcai.service.dogService.starter.StartService;
import com.ncell.wangcai.service.dogService.threadFactory.MyThreadFactory;
import com.ncell.wangcai.service.input.document.impl.DocumentServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import static java.lang.Thread.sleep;

/**
 * dog启动后正常运行的主程序
 *
 * 包括
 * input部分运行
 * cns部分运行
 * output部分运行
 *
 *
 * @author anliwei
 * @Date 2020/6/27 16:44
 *
 */
@AllArgsConstructor
@Data
@Service("startServiceImpl")
public class StartServiceImpl implements StartService {


    CellWarehouse cellWarehouse;
    MessageWarehouse messageWarehouse;
    DocumentWarehouse documentWarehouse;
    NormalizedDocumentWarehouse normalizedDocumentWarehouse;

    PojoCreatServiceImpl pojoCreatService;
    PojoImpulseServiceImpl pojoImpulseService;
    PojoStateServiceImpl pojoStateService;

    MessageSendServiceImpl messageSendService;

    LoadServiceImpl loadService;

    MyThreadFactory myThreadFactory;

    DocumentToCellConvertServiceImpl documentToCellConvertService;

    DocumentServiceImpl documentService;

    ManagerServiceImpl managerService;

    InputIndicator inputIndicator;

    CnsIndicator cnsIndicator;

    ServiceIndicator serviceIndicator;



    @Override
    public void doStartService() {

        doSystemStateService();
        doInputRunningService();
        doCnsRunningService();
    }

    /**
     * 系统状态服务
     * 获取系统各个部分状态，
     * 为各种服务运行提供信息
     */
    public void  doSystemStateService(){

        myThreadFactory.getPool().execute(new Runnable() {
            @Override
            public void run() {
                //将线程名称注册到线程表中。
                myThreadFactory.getThreadNameHashMap().put("SystemStateService",Thread.currentThread().getName());
                //状态服务
                stateService();

            }
        });



    }

    /**
     * 使用并发启动input各种服务，
     */
    public void doInputRunningService(){

        myThreadFactory.getPool().execute(new Runnable() {
            @Override
            public void run() {

                //将线程名称注册到线程表中。
                myThreadFactory.getThreadNameHashMap().put("inputService",Thread.currentThread().getName());
                //输入服务
                inputService();

            }
        });



    }


    /**
     * 使用并发启动cns各种服务，
     */
    public void doCnsRunningService() {

        /**
         * 将输入信息转换成细胞
         * 创建新的pojo
         * 发送消息
         * 确定pojo状态
         * 将输出转换成各种信号（目前暂未加入）
         * 四个进程同时进行
         */
        myThreadFactory.getPool().execute(new Runnable() {
            @Override
            public void run() {

                //将线程名称注册到线程表中。
                myThreadFactory.getThreadNameHashMap().put("createPojo",Thread.currentThread().getName());
                //1.创建新的pojo服务
                createPojo();

            }
        });



        myThreadFactory.getPool().execute(new Runnable() {
            @Override
            public void run() {

                //将线程名称注册到线程表中。
                myThreadFactory.getThreadNameHashMap().put("releaseImpulse",Thread.currentThread().getName());
                //2.发送信息
                releaseImpulse();

            }
        });
        myThreadFactory.getPool().execute(new Runnable() {
            @Override
            public void run() {

                //将线程名称注册到线程表中。
                myThreadFactory.getThreadNameHashMap().put("changeState",Thread.currentThread().getName());
                //3.改变状态
                changeState();

            }
        });
        myThreadFactory.getPool().execute(new Runnable() {
            @Override
            public void run() {

                //将线程名称注册到线程表中。
                myThreadFactory.getThreadNameHashMap().put("sendMessage",Thread.currentThread().getName());
                //4.消息发送
                sendMessage();

            }
        });

        myThreadFactory.getPool().execute(new Runnable() {
            @Override
            public void run() {

                //将线程名称注册到线程表中。
                myThreadFactory.getThreadNameHashMap().put("convertInput",Thread.currentThread().getName());
                //转换细胞
                convertInput();

            }
        });

    }

    /**
     * 使用并发启动output各种服务，
     */
    public void doOutputRunningService() {

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

            //如果兴奋队列不为空，也就是有细胞处于兴奋状态
            while (!cellWarehouse.getExcitedCellQueueForGenerateNewCell().isEmpty()) {
                pojoCreatService.doCreatService();
                System.out.println("create pojo");


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


            if (!normalizedDocumentWarehouse.getNormalizedDocumentLinkedBlockingQueue().isEmpty()) {

            try {
                documentToCellConvertService.doService();
                //System.out.println("转换输入文档");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }}
        }
    }

    /**
     * 输入部分的服务
     */
    public void inputService(){

        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            //如果文档队列不为空，也就是有文档未标准化
            while (!documentWarehouse.getDocumentLinkedBlockingQueue().isEmpty()) {
                documentService.doService();

            }
            //如果要处理的文档文件夹不为空，也就是c://ncell//doc有文档未标准化
            while (inputIndicator.getDocumentFileFolderState()!=0) {
                documentService.doService();
               // System.out.println("normalize document");


            }
        }

    }

    /**
     * 获取系统各个部分信息并添加到indicator中
     */

    public void stateService(){

        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            managerService.obtainSystemStateAndUpdateIndicator();

            /*//如果文档队列不为空，也就是有文档未标准化
            while (!documentWarehouse.getDocumentLinkedBlockingQueue().isEmpty()) {
                documentService.doService();
                System.out.println("normalize document");


            }*/
        }

    }


}
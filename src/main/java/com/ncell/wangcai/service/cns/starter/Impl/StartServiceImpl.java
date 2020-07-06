package com.ncell.wangcai.service.cns.starter.Impl;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import com.ncell.wangcai.pojo.cns.main.warehouse.MessageWarehouse;
import com.ncell.wangcai.service.cns.main.physiology.message.impl.MessageSendServiceImpl;
import com.ncell.wangcai.service.cns.main.physiology.pojo.impl.PojoCreatServiceImpl;
import com.ncell.wangcai.service.cns.main.physiology.pojo.impl.PojoImpulseServiceImpl;
import com.ncell.wangcai.service.cns.main.physiology.pojo.impl.PojoStateServiceImpl;
import com.ncell.wangcai.service.cns.starter.StartService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

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

    PojoCreatServiceImpl pojoCreatService;
    PojoImpulseServiceImpl pojoImpulseService;
    PojoStateServiceImpl pojoStateService;

    MessageSendServiceImpl messageSendService;

    /**
     * 使用并发启动各种服务，
     * 注意，load服务是单独启动的
     */
    public void doStartService(){



        //创建线程池
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("Thread-pool-%d").build();

        //Common Thread Pool
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());


        CountDownLatch latch = new CountDownLatch(4);

        /**
         * 创建新的pojo
         * 发送消息
         * 确定pojo状态
         * 三个进程同时进行
         */
        pool.execute(new Runnable() {
            @Override
            public void run() {
                //1.创建新的pojo服务
                createPojo();
               // latch.countDown();
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                //2.发送信息
                releaseImpulse();
               // latch.countDown();
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                //3.改变状态
                changeState();
               // latch.countDown();
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                //4.消息发送
                sendMessage();
              //  latch.countDown();
            }
        });
        //todo 并发处理要改进一下
        /*try {
            // 一定记得加上timeout时间，防止阻塞主线程
            latch.await(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //5.关闭线程池
       // pool.shutdown();//gracefully shutdown


    }


    /**
     * 生成新的pojo，根据兴奋细胞组合
     */
    @Override
    public void createPojo() {
        //如果兴奋队列不为空，也就是有细胞处于兴奋状态
        while(!cellWarehouse.getExcitedCellQueueForGenerateNewCell().isEmpty()){
            pojoCreatService.doCreatService();

            System.out.println("create pojo");
        }

    }

    /**
     * 发送神经冲动，产生消息（但是只是发送到消息仓库）
     */
    @Override
    public void releaseImpulse() {
        //如果兴奋队列不为空，也就是有细胞处于兴奋状态
        while(!cellWarehouse.getExcitedCellQueueForSendMessage().isEmpty()){
            pojoImpulseService.doPojoImpulseService();

            System.out.println("impulse ");
        }

    }

    /**
     * 根据收到的消息决定细胞的状态
     */
    @Override
    public void changeState() {
        //如果接受到消息的细胞队列不为空，也就是有细胞处于部分兴奋状态
        while(!cellWarehouse.getPartExcitedCell().isEmpty()){

            pojoStateService.doPojoStateService();

            System.out.println("change state");
        }

    }

    /**
     * 发送消息到具体目标细胞
     */
    @Override
    public void sendMessage() {
        //如果消息仓库中消息队列不为空
        while(!messageWarehouse.getMessageQueue().isEmpty()){
            messageSendService.doSendMessageService();
        }

        System.out.println("send message");
    }
}

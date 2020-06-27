package com.ncell.wangcai.service.cns.starter.Impl;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.ncell.wangcai.service.cns.main.physiology.pojo.impl.PojoCreatServiceImpl;
import com.ncell.wangcai.service.cns.main.physiology.pojo.impl.PojoImpulseServiceImpl;
import com.ncell.wangcai.service.cns.main.physiology.pojo.impl.PojoStateServiceImpl;
import com.ncell.wangcai.service.cns.starter.StartService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    LoadServiceImpl loadService;
    PojoCreatServiceImpl pojoCreatService;
    PojoImpulseServiceImpl pojoImpulseService;
    PojoStateServiceImpl pojoStateService;

    /**
     * 使用并发启动各种服务，
     * 注意，load服务是单独启动的
     */
    public void doStartService(){

        //加载pojo单独进行
        this.loadPojo();

        //创建线程池
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();

        //Common Thread Pool
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

       // pool.execute(()-> System.out.println(Thread.currentThread().getName()));

        CountDownLatch latch = new CountDownLatch(3);

        pool.execute(new Runnable() {
            @Override
            public void run() {
                //1.创建新的pojo服务
                createPojo();
                latch.countDown();
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                //2.发送信息
                releaseImpulse();
                latch.countDown();
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                //3.改变状态
                changeState();
                latch.countDown();
            }
        });
        //todo 并发处理要改进一下
        try {
            // 一定记得加上timeout时间，防止阻塞主线程
            latch.await(3000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //5.关闭线程池
        pool.shutdown();//gracefully shutdown


    }

    /**
     * 从数据库加载
     */
    @Override
    public void loadPojo() {
        loadService.doLoadService();
    }

    /**
     * 生成新的pojo，根据兴奋细胞组合
     */
    @Override
    public void createPojo() {

        while(true){
            pojoCreatService.doCreatService();
            //todo 如果不加sleep，cpu使用基本在95%以上
            try {
                sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 发送神经冲动，产生消息（但是只是发送到消息仓库）
     */
    @Override
    public void releaseImpulse() {
        while(true){
            pojoImpulseService.doPojoImpulseService();
            try {
                sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 根据收到的消息决定细胞的状态
     */
    @Override
    public void changeState() {
        while(true){
            pojoStateService.doPojoStateService();
            try {
                sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

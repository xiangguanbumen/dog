package com.ncell.wangcai.service.dogService.threadFactory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * @author anliwei
 * @Date 2020/7/9 16:02
 */
@Data
@Component("myThreadFactory")
public class MyThreadFactory {

    ThreadFactory namedThreadFactory = null;
    ExecutorService pool = null;

    /**
     * 所有的运行的线程在这里注册，
     * 第一个String保存服务名称，第二个String保存线程名称
     */
    ConcurrentHashMap<String,String> threadNameHashMap = new ConcurrentHashMap<>(200);

    MyThreadFactory() {
        /**
         * 创建线程池
         */

        namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("Thread-pool-%d").build();

        /**
         * Common Thread Pool
         */

        pool = new ThreadPoolExecutor(32, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    }


    /**
     *  根据线程名称查找线程，线程名称可以在threadNameHashMap中根据服务名称查找
     */

    public  Thread getThreadByName(String threadName) {
        for (Thread t : Thread.getAllStackTraces().keySet()) {
            if (t.getName().equals(threadName)) {
                System.out.println(t.getName());
                return t;
            }
        }
        return null;
    }



}
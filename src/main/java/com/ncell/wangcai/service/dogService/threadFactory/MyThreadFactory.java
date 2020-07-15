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
}
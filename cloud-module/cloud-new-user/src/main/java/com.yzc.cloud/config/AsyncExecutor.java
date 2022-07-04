package com.yzc.cloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: SanZ
 * @DATE: 2022/6/29 14:53
 */
@Configuration
public class AsyncExecutor  {
    private static final Logger logger = LoggerFactory.getLogger(AsyncExecutor.class);

    //核心线程数
    private static final int CORE_POOL_SIZE = 5;

    //最大线程数
    private static final int MAX_POOL_SIZE = 5;

    //队列大小
    private static final int QUEUE_CAPACITY = 50;

    //线程池中的线程的名称前缀
    private static final String THREAD_NAME = "YzcExecutor-";


   // @Bean
    public ThreadPoolTaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(CORE_POOL_SIZE);
        //配置最大线程数
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        //配置队列大小
        executor.setQueueCapacity(QUEUE_CAPACITY);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(THREAD_NAME);
        //配置线程池拒绝策略，我设置为CallerRunsPolicy，当线程和队列都满了，由发起线程的主线程自己执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

}

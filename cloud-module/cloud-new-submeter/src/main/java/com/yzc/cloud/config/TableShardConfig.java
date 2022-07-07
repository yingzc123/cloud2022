package com.yzc.cloud.config;

import org.apache.ibatis.plugin.Interceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  SanZ 全局配置 不建议修改
 */
@Configuration
//@ConditionalOnProperty(value = "enable", prefix = "lfl.shard",havingValue = "true")
public class TableShardConfig {

    /**
     * author:SanZ
     * DATE:2022/5/6
     */
    @Bean
    public Interceptor tableShardInterceptor(){
        return new TableShardInterceptorConfig();
    }
}

package com.yzc.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: SanZ
 * @DATE: 2022/6/30 17:23
 */
@SpringBootApplication
@MapperScan("com.yzc.cloud.dao")
public class SecurityApi {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApi.class,args);
    }
}

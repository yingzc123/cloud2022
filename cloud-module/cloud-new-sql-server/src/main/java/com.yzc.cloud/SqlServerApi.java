package com.yzc.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: SanZ
 * @DATE: 2022/6/22 13:39
 */
@SpringBootApplication
public class SqlServerApi {
    public static void main(String[] args) {
        SpringApplication.run(SqlServerApi.class, args);
    }
}

package com.yzc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author: SanZ
 * @DATE: 2022/6/21 16:52
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableAsync
public class UserApi {
    public static void main(String[] args) {
        SpringApplication.run(UserApi.class, args);
    }
}

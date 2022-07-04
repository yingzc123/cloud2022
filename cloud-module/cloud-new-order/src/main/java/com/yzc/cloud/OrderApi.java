package com.yzc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: SanZ
 * @DATE: 2022/6/21 18:11
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderApi {
    public static void main(String[] args) {
        SpringApplication.run(OrderApi.class, args);
    }
}

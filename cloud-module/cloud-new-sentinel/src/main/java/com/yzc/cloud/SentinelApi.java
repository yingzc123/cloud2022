package com.yzc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: SanZ
 * @DATE: 2022/7/5 11:14
 */

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelApi {
    public static void main(String[] args) {
        SpringApplication.run(SentinelApi.class,args);
    }
}

package com.yzc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: SanZ
 * @DATE: 2022/6/27 15:09
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApi {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApi.class, args);
    }
}

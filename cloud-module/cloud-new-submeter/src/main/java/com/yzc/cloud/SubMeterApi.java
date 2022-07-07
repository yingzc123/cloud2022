package com.yzc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: SanZ
 * @DATE: 2022/7/7 10:34
 */

@SpringBootApplication
@EnableDiscoveryClient
public class SubMeterApi {
    public static void main(String[] args) {
        SpringApplication.run(SubMeterApi.class,args);
    }
}

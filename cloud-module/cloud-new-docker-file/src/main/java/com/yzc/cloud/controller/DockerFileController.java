package com.yzc.cloud.controller;

import cn.hutool.core.lang.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: SanZ
 * @DATE: 2022/7/14 23:10
 */
@RestController
@RequestMapping("/docker")
public class DockerFileController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String helloDocker(){
        return "holler docker :"+port  +"  " + UUID.randomUUID().toString();
    }

}

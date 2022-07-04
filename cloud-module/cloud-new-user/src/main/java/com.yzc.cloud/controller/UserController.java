package com.yzc.cloud.controller;


import com.alibaba.fastjson.JSONArray;
import com.yzc.cloud.entity.User;
import com.yzc.cloud.feign.OrderFeign;
import com.yzc.cloud.result.ResultObject;
import com.yzc.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: SanZ
 * @DATE: 2022/6/21 16:55
 */

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private OrderFeign orderFeign;

    @Autowired
    private AmqpTemplate rabbitTemplate;


    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Date date = new Date();//现在的日期
        cal.setTime(date);
        int i = cal.get(Calendar.HOUR_OF_DAY);
        int i1 = cal.get(Calendar.MINUTE);
        int i2 = cal.get(Calendar.SECOND);
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);

    }

    @GetMapping
    public String resultObject() {
        log.info("data：{}", 123);
        return "hello";
    }

    @PostMapping("/getLsit")
    public ResultObject getLsit() {
        int i =1/0;
        return ResultObject.success(userService.list());
    }

    @PostMapping("/getOrder")
    public String getOrder() throws URISyntaxException {
        log.info("准备调用订单服务：{}", 123);
        URI uri = new URI("http://172.16.177.41:9002/cloudOrder");
        ResponseEntity<String> resp = restTemplate.postForEntity(uri, null, String.class);
        System.out.println(resp.getBody());
        return resp.getBody();
    }


    @PostMapping("/getOrderFeign")
    public String getOrderFeign() throws URISyntaxException {
        log.info("准备调用订单服务：{}", 123);
        JSONArray jsonArray = orderFeign.returnList();
        return jsonArray.toString();
    }


    @GetMapping("/mq")
    public String mq() throws URISyntaxException {
        log.info("准备调用mq");
        rabbitTemplate.convertAndSend("order_succeed", "", "你好啊");
        return "yes";
    }

    @GetMapping("/testAsync")
    public String testAsync()   throws Exception{
        userService.testAsync();
        return "yes";
    }


    @GetMapping("/updateUser")
    public void updateUser() {
        userService.updateUser();
    }


}

package com.yzc.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yzc.cloud.handler.FallbackHandler;
import com.yzc.cloud.handler.SentinelHandler;
import com.yzc.cloud.result.ResultObject;
import com.yzc.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: SanZ
 * @DATE: 2022/7/5 11:19
 */

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String returnString(){
        log.info("我被访问了");
        return "hello";
    }


    @GetMapping("/returnHello")
    @SentinelResource(value = "returnHello",
            blockHandlerClass = SentinelHandler.class,
            blockHandler = "resultObject",
            fallbackClass = FallbackHandler.class,
            fallback ="resultObject"
          )
    public ResultObject returnHello(){
        return ResultObject.success(userService.returnHello());
    }


}

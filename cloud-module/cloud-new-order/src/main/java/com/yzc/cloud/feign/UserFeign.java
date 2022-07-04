package com.yzc.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: SanZ
 * @DATE: 2022/6/29 13:58
 */
@Component
@FeignClient(name = "cloud-user",path = "/user")
public interface UserFeign {

    @GetMapping
     String resultObject();

    @GetMapping("/updateUser")
    void updateUser();
}

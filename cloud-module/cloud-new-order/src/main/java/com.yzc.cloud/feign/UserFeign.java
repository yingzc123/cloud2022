package com.yzc.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: SanZ
 * @DATE: 2022/6/29 13:58
 */
@Component
@FeignClient(name = "cloud-user",path = "/")
public interface UserFeign {

    @GetMapping("/user")
     String resultObject();

    @GetMapping("/user/updateUser")
    void updateUser();
}

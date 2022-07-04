package com.yzc.cloud.feign.proxyFeign;

import com.yzc.cloud.feign.UserFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: SanZ
 * @DATE: 2022/6/29 14:20
 */
@Component
@Slf4j
public class ProxyUserFeign {
    @Autowired
    private UserFeign userFeign;

    public String returnString(){
        log.info("准备调用resultObject");
        return userFeign.resultObject();
    }


    public void updateUser(){
         userFeign.updateUser();
    }



}

package com.yzc.cloud.service.impl;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yzc.cloud.handler.SentinelHandler;
import com.yzc.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SanZ
 * @since 2022-06-21
 */
@Service
@Slf4j
public class UserServiceImpl  implements UserService {


    @Override
    public String returnHello() {
        int i=1/0;
        return "returnHello";
    }
}

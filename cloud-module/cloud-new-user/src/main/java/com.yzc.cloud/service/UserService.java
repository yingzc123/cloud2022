package com.yzc.cloud.service;

import com.yzc.cloud.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SanZ
 * @since 2022-06-21
 */
public interface UserService extends IService<User> {

    List<User> returnAll();


    String returnString();

    void testAsync() throws InterruptedException;


    void updateUser();





}

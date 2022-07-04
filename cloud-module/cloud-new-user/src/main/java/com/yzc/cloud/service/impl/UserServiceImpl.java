package com.yzc.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yzc.cloud.entity.User;
import com.yzc.cloud.dao.UserMapper;
import com.yzc.cloud.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.LongAdder;

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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public List<User> returnAll() {
        return list();
    }

    @Override
    public String returnString() {
        return list().get(0).getUserName();
    }

    LongAdder longAdder  =new LongAdder();
    @Override
    //@Async("getAsyncExecutor")
    @Async
    public void testAsync() throws InterruptedException {
       // Thread.sleep(100);
        longAdder.increment();
        log.info("UserServiceImpl/testAsync end:{}",Thread.currentThread().getName()+" longAdder:"+longAdder);
    }

    @Override
    public void updateUser() {
        update(new UpdateWrapper<User>().set("user_name","BABA").eq("user_id",1));
    }
}

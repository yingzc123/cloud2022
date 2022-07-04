package com.yzc.cloud.service;

import com.yzc.cloud.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Sanz
 * @since 2022-06-30
 */
public interface UserService extends IService<User>, UserDetailsService {
    User findUserByName(String userName);

}

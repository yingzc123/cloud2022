package com.yzc.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yzc.cloud.entity.Role;
import com.yzc.cloud.entity.User;
import com.yzc.cloud.dao.UserMapper;
import com.yzc.cloud.service.RoleService;
import com.yzc.cloud.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Sanz
 * @since 2022-06-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = findUserByName(username);
        Integer roleId = user.getRoleId();
        List<Role> role = roleService.listByIds(Arrays.asList(roleId.toString().split(",")));
        user.setRoleList(role);
        return user;
    }


    @Override
    public User findUserByName(String userName) {
        return getOne(new QueryWrapper<User>().eq("user_number",userName));
    }
}

package com.itheima.springboot.service.impl;

import com.itheima.springboot.mapper.UserMapper;
import com.itheima.springboot.pojo.User;
import com.itheima.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jianglinchen
 * @description 用户服务接口实现
 * @date 2019/12/22 / 22:31
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

}

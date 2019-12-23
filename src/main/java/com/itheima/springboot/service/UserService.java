package com.itheima.springboot.service;

import com.itheima.springboot.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author jianglinchen
 * @description 用户服务层接口
 * @date 2019/12/22 / 21:26
 */
public interface UserService {

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    public User getUserByUsername(String username);

}

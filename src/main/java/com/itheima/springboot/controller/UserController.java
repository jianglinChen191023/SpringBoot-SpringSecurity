package com.itheima.springboot.controller;

import com.itheima.springboot.pojo.User;
import com.itheima.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jianglinchen
 * @description 用户控制器
 * @date 2019/12/22 / 22:34
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/info")
    @ResponseBody
    public User getUser() {

        return userService.getUserByUsername("zhangsan");
    }

}

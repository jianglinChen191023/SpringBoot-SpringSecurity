package com.itheima.springboot;

import com.itheima.springboot.mapper.UserMapper;
import com.itheima.springboot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        User zhangsan = userMapper.getUserByUsername("zhangsan");
        System.out.println(zhangsan);
        System.out.println(zhangsan.getUsername());
    }
}

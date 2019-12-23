package com.itheima.springboot.service.impl;

import com.itheima.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author jianglinchen
 * @description 自定义用户认证
 * @date 2019/12/22 / 23:10
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired()
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 获取用户信息
        com.itheima.springboot.pojo.User user = userMapper.getUserByUsername(username);
        if (null == user) {
            return null;
        }

        String password = passwordEncoder.encode(user.getPassword());
        System.out.println("验证的密码加密后= " + password);

        boolean enabled = false;
        boolean accountNonExpired = false;
        boolean credentialsNonExpired = false;
        // 判断用户是否被冻结
        boolean accountNonLocked = true;

        return new User(username, password, true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}

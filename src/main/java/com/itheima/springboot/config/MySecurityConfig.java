package com.itheima.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author jianglinchen
 * @description 我的SpringSecurity配置
 * @date 2019/12/22 / 22:56
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 建立BCryptPasswordEncoder的bean
     * <p>
     * 获取方法:
     *
     * @return
     * @Autowired private PasswordEncoder passwordEncoder;
     * </p>
     */
    @Bean
    public PasswordEncoder create() {

        return new BCryptPasswordEncoder();
    }


    /**
     * 默认表单
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ((HttpSecurity) ((HttpSecurity) ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl) http
                .authorizeRequests() // 授权请求
                .anyRequest()).authenticated()// 所有的请求都认证通过了之后才能访问
                .and())// 并且
                .formLogin()// 通过表单验证的方式认证
                .and())// 并且
                .httpBasic();// 默认的方式
    }

}

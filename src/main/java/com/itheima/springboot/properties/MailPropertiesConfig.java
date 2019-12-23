package com.itheima.springboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author jianglinchen
 * @description springBoot基于java类属性配置和读取
 * @title 标题
 * @date 2019/12/22 / 17:22
 * <p>
 * ConfigurationProperties(prefix = "mail") // 定义属性的前缀
 * Component // 交给spring容器管理
 * <p>
 */
@ConfigurationProperties(prefix = "mail")
@Component
public class MailPropertiesConfig {

    private String host;

    private String username;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}




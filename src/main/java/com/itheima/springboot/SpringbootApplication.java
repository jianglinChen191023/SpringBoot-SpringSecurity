package com.itheima.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 引导类
 *
 * @author jianglinchen
 * <p>
 * @SpringBootApplication: 会自动扫描这个类所在包的子包下的所有bean 初始化
 * @MapperScan(basePackages = "com.itheima.springboot.mapper")
 * </p>
 */
@SpringBootApplication
@MapperScan(basePackages = "com.itheima.springboot.mapper")
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}

package com.itheima.springboot.controller;

import com.itheima.springboot.properties.MailPropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jianglinchen
 * @description 测试控制器
 * @date 2019/12/22 / 2:41
 * @update
 */
@Controller
public class HelloWorldController {

    // 使用@value注解获取到属性文件中的值
    /**
     * ${属性的名称}和application.properties中的属性名一致
     */
    @Value("${mailhost}")
    private String mailhost;

    @Value("${mailusername}")
    private String mailusername;

    @Autowired
    private MailPropertiesConfig mailPropertiesConfig;

    @RequestMapping("/hello")
    @ResponseBody
    public String showHello() {
        System.out.println("通过@value注解获取到的属性的值:");
        System.out.println("mailhost=" + this.mailhost);
        System.out.println("mailusername=" + this.mailusername);

        System.out.println("通过java类配置映射得到的值: ");
        System.out.println("mailhost="+mailPropertiesConfig.getHost());
        System.out.println("mailusername=" + mailPropertiesConfig.getUsername());

        return "hello world";
    }
}

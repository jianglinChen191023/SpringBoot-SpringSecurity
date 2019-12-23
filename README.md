# springboot
springboot +安全入门

> [一、SpringBoot的介绍](#er1)</br>
> [二、SpringBoot HelloWorld入门](#er2)</br>
> [三、说明](#er3)</br>
> [四、springBoot自定义属性的配置及获取属性值](#er4)</br>
> [五、springBoot基于java类属性配置和读取 ](#er5)</br>
> [六、springBoot集成mybatis](#er6)</br>
> [七、springBoot集成mybatis批量扫描](#er7)</br>
> [八、springBoot处理查询数据返回用户(service层)](#er8)</br>
> [九、springSecurity入门](#er9)</br>
> [十、如果你的版本不是默认表单的,可以自己设置springSecurity的表单认证配置](#er10)</br>
> [十一、自定义用户认证](#er11)</br>

## SpringBoot初始化
[SpringBoot+WEB项目初始化下载地址](https://start.spring.io/)

![在这里插入图片描述](https://img-blog.csdnimg.cn/2019122216430516.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwNzEy,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222164254218.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwNzEy,size_16,color_FFFFFF,t_70)
![初始化项目](https://img-blog.csdnimg.cn/2019122216492649.png)
## <span id="er1">一、SpringBoot的介绍</span>


## 二、SpringBoot HelloWorld入门
### <span id="er2">2.1 解压并导入上面下载的springboot项目 </span>
file->new->Module from Existing Sources,选中解压后的springboot项目
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222164825643.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwNzEy,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222165144266.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwNzEy,size_16,color_FFFFFF,t_70)
### 2.2 创建controller包->创建HelloWorld类![在这里插入图片描述](https://img-blog.csdnimg.cn/2019122216541462.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwNzEy,size_16,color_FFFFFF,t_70)
<br/>
```
package com.itheima.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jianglinchen
 * @description 测试控制器
 * @date 2019/12/22 / 2:41
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    @ResponseBody
    public String showHello() {

        return "hello world";
    }
    
}

```
### 2.3 启动springboot,自带的SpringbootApplication类,启动main即可
```
package com.itheima.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}

```
### 2.4 浏览器访问 http://localhost:8080/hello
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222165939487.png)
## 三、<span id="er3">说明</span>
### 3.1 @SpringBootApplication: 会自动扫描这个类所在包的子包下的所有bean 初始化
### 3.2 application.properties可以更改端口
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222171039504.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222171048573.png)
## <span id="er4">四、springBoot自定义属性的配置及获取属性值</sapn>
### 4.1 application.properties文件

```
#配置访问的端口
server.port=80

#自定义属性的配置
mailhost=127.0.0.1
mailusername=zhangsan
```

### 4.2 HelloWorldController类
```
package com.itheima.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

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
    private String host;

    @Value("${mailusername}")
    private String mailusername;

    @RequestMapping("/hello")
    @ResponseBody
    public String showHello() {
        System.out.println("获取到的属性的值:");
        System.out.println("host=" + this.host);
        System.out.println("mailusername=" + this.mailusername);

        return "hello world";
    }
}

```
### 4.3 访问http://localhost/hello后控制台输出的结果
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222171759651.png)
## <span id="er5">五、springBoot基于java类属性配置和读取 </span>
### 5.1 application.properties文件

```
#配置访问的端口
server.port=80

#自定义属性的配置
mailhost=127.0.0.1
mailusername=zhangsan

mail.host=127.0.0.1
mail.username=zhangsan
```

### 5.2 MailPropertiesConfig类
```
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

```

### 5.3 HelloWorldController类

```
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


```
### 5.4 访问 http://localhost/hello后控制台输出的结果
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222183648206.png)

## <span id="er6">六、springBoot集成mybatis</sapn>
### 6.1 添加依赖

```
<!-- 集成mybatis -->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.1</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
```

  ### 6.2 配置application.properties

```
# 配置访问的端口
server.port=80

# 自定义属性的配置
mailhost=127.0.0.1
mailusername=zhangsan

mail.host=127.0.0.1
mail.username=zhangsan

# 配置数据库连接池
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql:///springboot?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=mysql

```
### 6.3 建表 user.sql

```
/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : springboot

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-12-22 20:59:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '账户',
  `password` varchar(64) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangsan', '123');
INSERT INTO `user` VALUES ('2', '123', '123');

```
### 6.4 创建USER实体类

```
package com.itheima.springboot.pojo;

/**
 * @author jianglinchen
 * @description 用户实体类
 * @date 2019/12/22 / 20:22
 */
public class User {

    private Integer id;
    private String username;
    private String password;

    public User() {

    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

```
### 6.5 配置mapper

```
package com.itheima.springboot.mapper;

import com.itheima.springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author jianglinchen
 * @description 描述
 * @date 2019/12/22 / 20:25
 * <p>
 * @Mapper : spring管理接口的实现类代理对象
 *
 * </p>
 */
 @Mapper
public interface UserMapper {

    /**
     * 根据用户名查询用户的信息
     *
     * @param username
     * @return
     */
    @Select(value = "SELECT * FROM USER WHERE username = #{username}")
    public User getUserByUsername(String username);

}

```
### 6.6 在test包下测试
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222210320508.png)
```
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


```

### 6.7 结果
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222210339234.png)
## <span id="er7">七、springBoot集成mybatis批量扫描</sapn>
### 7.1 SpringbootApplication添加注解: @MapperScan(basePackages = "com.itheima.springboot.controller.mapper")

```
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

```
#### 7.1.1 mapper包下不用添加mapper注解了
```
package com.itheima.springboot.mapper;

import com.itheima.springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author jianglinchen
 * @description 描述
 * @date 2019/12/22 / 20:25
 * <p>
 * @Mapper : spring管理接口的实现类代理对象
 *
 * </p>
 */
//@Mapper
public interface UserMapper {

    /**
     * 根据用户名查询用户的信息
     *
     * @param username
     * @return
     */
    @Select(value = "SELECT * FROM USER WHERE username = #{username}")
    public User getUserByUsername(String username);

}

```

### 7.2 测试通过
```
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

```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222212505753.png)


## <span id="er8">八、springBoot处理查询数据返回用户(service层)/sapn>
### 8.1 UserService接口

```
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

```
### 8.2 UserService接口实现

```
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

```
### 8.3 UserController控制器

```
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

```

### 8.4 访问 http://localhost/user/info
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222224408106.png)

## <span id="er9">九、springSecurity入门</sapn>
### 9.1 添加依赖

```
		<!-- 集成SpringSecurity -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
```
### 9.2 访问 http://localhost/user/info,这个时候就需要登录了
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222224956757.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwNzEy,size_16,color_FFFFFF,t_70)
### 9.2.1 可以看到控制台有一个默认密码,账号默认user,实际开发中需要自己定义
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222225123905.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwNzEy,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222225310926.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwNzEy,size_16,color_FFFFFF,t_70)

## <span id="er10">十、如果你的版本不是默认表单的,可以自己设置springSecurity的表单认证配置</sapn>
```
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
```

## <span id="er11">十一、自定义用户认证
### 11.1  步骤: 获取用户->校验用户->密码加密,需要实现接口: UserDetailsService
#### 11.1.1 获取用户
```
package com.itheima.springboot.service.impl;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author jianglinchen
 * @description 自定义用户认证
 * @date 2019/12/22 / 23:10
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 密码需要从数据库中查询出来,AuthorityUtils权限信息
        return new User(username, "123123", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}

```
#### 11.1.2 校验用户
```
package com.itheima.springboot.service.impl;

import com.itheima.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 获取用户信息
        com.itheima.springboot.pojo.User user = userMapper.getUserByUsername(username);
        if (null == user) {
            return null;
        }

        String password = user.getPassword();

        // AuthorityUtils权限信息
        return new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}


```

##### 11.1.2.1 分析security自带的用户类
```
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.springframework.security.core.userdetails;

import java.io.Serializable;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

public interface UserDetails extends Serializable {

	// 拥有的权限
    Collection<? extends GrantedAuthority> getAuthorities();

    String getPassword();

    String getUsername();

	// true: 用户没有过期
    boolean isAccountNonExpired();
	
	// true: 表示这个用户没有被锁住
	// false: 被冻结,可以恢复
    boolean isAccountNonLocked();
	
	// 密码是否过期
    boolean isCredentialsNonExpired();
	
	// 是否可用
	// 账户被删除
    boolean isEnabled();
}

```
##### 11.1.2.2 UserDetailsServiceImpl类

```
package com.itheima.springboot.service.impl;

import com.itheima.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 获取用户信息
        com.itheima.springboot.pojo.User user = userMapper.getUserByUsername(username);
        if (null == user) {
            return null;
        }

        String password = user.getPassword();


        boolean enabled = false;
        boolean accountNonExpired = false;
        boolean credentialsNonExpired = false;
        // 判断用户是否被冻结
        boolean accountNonLocked = false;

        return new User(username, password, true, true, true, accountNonLocked, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}

```
##### 11.1.2.3 登录结果
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191222235227783.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwNzEy,size_16,color_FFFFFF,t_70)

#### 11.1.3 密码加密 需要实现一个passwordEncoder接口,建议使用BCryptPasswordEncoder
##### 11.1.3.1 分析 passwordEncoder
```
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.springframework.security.crypto.password;

public interface PasswordEncoder {
	// 密码加密
    String encode(CharSequence var1);

	// 匹配,密码是否一致
	// var1 数据库密码(数据库密码需要加密)
	// va2 加密密码
    boolean matches(CharSequence var1, String var2);

    default boolean upgradeEncoding(String encodedPassword) {
        return false;
    }
}

```
##### 11.1.3.2 MySecurityConfig类

```
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

```
##### 11.1.3.3 UserDetailsService自定义认证类

```
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

```
##### 11.1.3.4 登录,先访问http://localhost/hello 会自动跳转到登录页面
数据库中看看账号密码
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191223003346402.png)<br/>
登录<br/>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191223003422633.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwNzEy,size_16,color_FFFFFF,t_70)
<br/>登录成功<br/>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191223003437619.png)
## 小技巧
|快捷键中的名称/快捷键  |作用  |
|--|--|
| Parameter Info/Ctrl+P  | 可以显示注解()内的参数信息 |

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

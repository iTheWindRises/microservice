package com.zwj.user.mapper;

import com.zwj.thrift.user.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @program microservice
 * @description:
 * @author: wj
 * @create: 2018/11/12 13:42
 */
@Mapper
public interface UserMapper {
    @Select("select id,username,password,real_name as realName," +
            "mobile,email from pe_user where id=#{id}")
    UserInfo getUserById(@Param("id")Integer id);
    @Select("select id,username,password,real_name as realName," +
            "mobile,email from pe_user where username=#{username}")
    UserInfo getUserByName(@Param("username")String username);

    @Insert("insert into pe_user (username,password,real_name,mobile,email) " +
            "values (#{u.username},#{u.password},#{u.realName},#{u.mobile},#{u.email})")
    void registerUser(@Param("u")UserInfo userInfo);

    @Select("select u.id,u.username,u.password,u.real_name as realName," +
            "u.mobile,u.email,t.info,t.description where u.id=#{id}" +
            "and u.id=t.user_id")
    UserInfo getTeacherById(@Param("id") int id);
}

package com.van.mapper;

import com.van.page.Page;
import com.van.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {


    List<Users> selectByExample();


    //分页查询用户表
    List<Users> queryPageUser(Page page);

    //查询总记录数
    Integer queryPageCount(Page page);

    //删除用户
    void delUsersById(@Param("userId") String userId);

    //更新用户
    void updUsers(@Param("users") Users users);

//    添加用户
    void addUsers(@Param("users") Users users);
}
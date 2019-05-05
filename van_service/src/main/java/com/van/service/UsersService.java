package com.van.service;

import com.van.pojo.Users;

import com.van.page.Page;

import java.util.List;

public interface UsersService {

//  查询所有用户
    List<Users> findAllUsers();

//    分页数据
    List<Users> selectPageList(Page page);

//    分页总数

    Integer selectPageCount(Page page);

//    根据用户id 删除用户
    void delUsersById(String userId);

    //更新用户
    void updUsers(Users users);

//    添加用户
    void addUsers(Users users);
}

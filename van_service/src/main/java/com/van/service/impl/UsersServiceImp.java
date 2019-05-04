package com.van.service.impl;

import com.van.mapper.UsersMapper;
import com.van.page.Page;
import com.van.pojo.Users;
import com.van.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImp implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<Users> findAllUsers() {
        return usersMapper.selectByExample();
    }

    @Override
    public List<Users> selectPageList(Page page) {
        return usersMapper.queryPageUser(page);
    }

    @Override
    public Integer selectPageCount(Page page) {
        return usersMapper.queryPageCount(page);
    }

    @Override
    public void delUsersById(String userId) {
        usersMapper.delUsersById(userId);
    }
}

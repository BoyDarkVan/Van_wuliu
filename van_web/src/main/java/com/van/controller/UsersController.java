package com.van.controller;

import com.van.page.Page;
import com.van.page.ResultMap;
import com.van.pojo.Users;
import com.van.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 用户控制器
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;


    /**
     * 用户的分页查询
     * @param page
     * @param limit
     * @return
     */

    @RequestMapping("/find")
    @ResponseBody
    public ResultMap<List<Users>> findUsers(Page page, @RequestParam("limit") int limit){

        page.setRows(limit);

        List<Users> usersList=usersService.selectPageList(page);

        int totals=usersService.selectPageCount(page);

        page.setTotalRecord(totals);

        return new ResultMap<List<Users>>("",usersList,0,totals);

    }

    @RequestMapping("/del/{userId}")
    public String delUsers(@PathVariable("userId") String userId){

        System.out.println("==========================="+userId);
        usersService.delUsersById(userId);

        return "users";
    }




    @RequestMapping("/page")
    public String finds(){

        return "users";
    }

}

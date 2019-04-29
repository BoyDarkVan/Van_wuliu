package com.van.controller;

import com.van.pojo.Admin;
import com.van.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String loginAdmin(Admin admin){

        Admin adm = adminService.loginAdmin(admin);

        System.out.println(adm);

        if(adm!= null){
            System.out.println("登陆成功!!");

            return "index";
        }else{
            System.out.println("登陆失败");
            return "error";
        }

    }

}

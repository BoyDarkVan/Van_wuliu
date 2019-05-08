package com.van.controller;

import com.van.pojo.Admin;
import com.van.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String loginAdmin(Admin admin,HttpSession session){

        Admin adm = adminService.loginAdmin(admin);
        if(adm!= null){
            System.out.println("登陆成功!!");
            session.setAttribute("admin",adm);
            return "tiaozhuan";
        }else{
            return "redirect:/login.jsp";
        }
    }

    //密码修改
    @RequestMapping("/updadm")
    public String updAdm(String adm_id, String adm_pwd,String old_pwd, HttpSession session){
        Object pwd=session.getAttribute("admPwd");
        if (old_pwd.equals(pwd)){
            adminService.updAdm(adm_id,adm_pwd);
            System.out.println("成功");
            return "updadm";
        }else {
            session.setAttribute("upderror","修改密码失败，请检查旧密码");
            return "updadm";
        }
    }
    //添加用户
    @RequestMapping("/addadm")
    public String addAdm(String adm_id, String adm_name, String adm_pwd){

        adminService.addAdm(adm_id, adm_name, adm_pwd);

        return "";

    }
    @RequestMapping("exit")
    public String exitAdm(HttpSession session){
        session.removeAttribute("admin");
        return "login.jsp";
    }

}

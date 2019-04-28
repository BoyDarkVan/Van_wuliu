package com.van.controller;

import com.van.moudle.Testpojo;
import com.van.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private TestService testService;


    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "admin_id") String user_id,
                        @RequestParam(value = "admin_pwd") String user_pwd,
                        HttpServletRequest request,
                        Model model) {
        Testpojo c_admin = new Testpojo(user_id, null, user_pwd);
        Testpojo get_admin = testService.login(c_admin);
        if (get_admin != null) {
            System.out.println("login success");
            request.getSession().setAttribute("user", get_admin);
            return "index";
        } else {
            System.out.println("login fail");
            model.addAttribute("failMessage", "登陆失败");
            return "login";
        }

    }

    public void change() {
        System.out.println("assasinggg");
    }
}


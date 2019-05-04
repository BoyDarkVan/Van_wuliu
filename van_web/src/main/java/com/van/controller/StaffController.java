package com.van.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.van.pojo.Orders;
import com.van.pojo.Staff;
import com.van.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @RequestMapping("findAllStaff")
    public String findAllStaff(Model model, @RequestParam(value = "param", required = true, defaultValue = "1") int currentPage){
            PageHelper.startPage(currentPage, 2);

            List<Staff> list = staffService.findAllStaff();

            PageInfo<Staff> pageInfo = new PageInfo<>(list);

            model.addAttribute("stafflist", pageInfo.getList());

            if (currentPage < 1) {
                currentPage = 1;
            }
            if (currentPage > pageInfo.getPages()) {
                currentPage = pageInfo.getPages();
            }
            model.addAttribute("currentPage", currentPage);
            model.addAttribute("totalpage", pageInfo.getPages());

        return "staff";

    }


}

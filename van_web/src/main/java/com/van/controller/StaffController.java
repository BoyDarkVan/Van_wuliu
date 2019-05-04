package com.van.controller;

import com.van.mapper.WarehouseMapper;
import com.van.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;
    /**
     * 分页查询所有仓库
     */
    @RequestMapping("/findAllStaff")
    public String findall_warehouse(Model model) {

            return "";
    }

    @RequestMapping("/addStaff")
    public String addWarehouse(Model model) {

        return "";
    }

}

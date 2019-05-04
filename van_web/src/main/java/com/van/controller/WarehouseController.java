package com.van.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.van.mapper.WarehouseMapper;
import com.van.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseMapper warehouseMapper;
    /**
     * 分页查询所有仓库
     */
    @RequestMapping("/findAllWarehouse")
    public String findall_warehouse(Model model) {

            return "";
    }


}

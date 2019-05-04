package com.van.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.van.pojo.Store;
import com.van.pojo.Warehouse;
import com.van.service.WarehouseService;
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
    private WarehouseService warehouseService;
    /**
     * 分页查询所有仓库
     */
    @RequestMapping("/findAllWarehouse")
    public String findAllWarehouse(Model model, @RequestParam(value = "param", required = true, defaultValue = "1") int currentPage){
        PageHelper.startPage(currentPage, 2);

        List<Warehouse> list = warehouseService.findAllWarehouse();

        PageInfo<Warehouse> pageInfo = new PageInfo<>(list);

        model.addAttribute("warelist", pageInfo.getList());

        if (currentPage < 1) {
            currentPage = 1;
        }
        if (currentPage > pageInfo.getPages()) {
            currentPage = pageInfo.getPages();
        }
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalpage", pageInfo.getPages());
            return "warehouse";
    }

    @RequestMapping("/addWarehouse")
    public String addWarehouse(Model model) {

        return "";
    }

}

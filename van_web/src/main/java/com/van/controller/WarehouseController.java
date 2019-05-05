package com.van.controller;

import com.van.page.Page;
import com.van.page.ResultMap;
import com.van.pojo.Warehouse;
import com.van.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public ResultMap<List<Warehouse>> findAllWarehouse(Page page, @RequestParam("limit") int limit){
        page.setRows(limit);
        List<Warehouse> warelist=warehouseService.findAllWarehouse(page);
        int total=warehouseService.findtotal(page);
        page.setTotalRecord(total);

        return new ResultMap<List<Warehouse>>("",warelist,0,total);

    }

    @RequestMapping("/addWarehouse")
    public String addWarehouse(Model model) {

        return "";
    }
    @RequestMapping("/del/{ckId}")
    public String delWare(@PathVariable("ckId") String ckId){
        warehouseService.delWare(ckId);
        return "warehouse";
    }

    @RequestMapping("page")
    public String finds(){

        return "warehouse";
    }

}

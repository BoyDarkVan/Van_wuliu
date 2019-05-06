package com.van.controller;

import com.van.page.Page;
import com.van.page.ResultMap;
import com.van.pojo.Warehouse;
import com.van.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    //添加
    @RequestMapping("/add")
    @ResponseBody
    public String addWarehouse(@RequestBody Warehouse warehouse) {
        warehouseService.addWarehouse(warehouse);
        return "";
    }

    //修改
    @RequestMapping("upd")
    @ResponseBody
    public void updWare(@RequestBody Warehouse warehouse){
        warehouseService.updWarehouse(warehouse);
    }

    //删除
    @RequestMapping("/del/{ckId}")
    public String delWare(@PathVariable("ckId") String ckId){
        warehouseService.delWare(ckId);
        return "warehouse";
    }

    //返回显示视图
    @RequestMapping("page")
    public String finds(){
        return "warehouse";
    }

    //返回修改视图
    @RequestMapping("addware")
    public String find(){
        return "addwarehouse";
    }

}

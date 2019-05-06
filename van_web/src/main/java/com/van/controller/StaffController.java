package com.van.controller;

import com.van.page.Page;
import com.van.page.ResultMap;
import com.van.pojo.Staff;
import com.van.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    //分页查询
    @RequestMapping("/findAllStaff")
    @ResponseBody
    public ResultMap<List<Staff>> findAllStaff(Page page, @RequestParam("limit") int limit){
        page.setRows(limit);
        List<Staff> stafflist=staffService.findAllStaff(page);
        int total=staffService.findPagetotal(page);
        page.setTotalRecord(total);

        return new ResultMap<List<Staff>>("",stafflist,0,total);
    }

    //添加
    @RequestMapping("/add")
    @ResponseBody
    public void addStaff(@RequestBody Staff staff){
        staffService.addStaff(staff);
    }
    
    //修改
    @RequestMapping("/upd")
    @ResponseBody
    public String updStaff(@RequestBody Staff staff){
        System.out.println(staff);
        staffService.updStaff(staff);
        return "";
    }

    //删除
    @RequestMapping("/del/{stId}")
    public String deleteStaff(@PathVariable("stId") String stId){
        staffService.deleteStaff(stId);
        return "staff";
    }

    //返回视图
    @RequestMapping("/page")
    public String finds(){
        return "staff";
    }
    @RequestMapping("/addstaff")
    public String find(){
        return "addstaff";
    }


}

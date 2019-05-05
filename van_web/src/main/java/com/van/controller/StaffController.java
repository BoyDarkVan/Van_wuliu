package com.van.controller;

import com.van.page.Page;
import com.van.page.ResultMap;
import com.van.pojo.Staff;
import com.van.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @RequestMapping("findAllStaff")
    public ResultMap<List<Staff>> findAllStaff(Page page, @RequestParam("limit") int limit){

        page.setRows(limit);

        List<Staff> stafflist=staffService.findAllStaff(page);
        int total=staffService.findPagetotal(page);
        page.setTotalRecord(total);

        return new ResultMap<List<Staff>>("",stafflist,0,total);

    }

    @RequestMapping("/page")
    public String finds(){

        return "staff";
    }


}

package com.van.controller;

import com.van.page.Page;
import com.van.page.ResultMap;
import com.van.pojo.*;
import com.van.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.List;


@Controller
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private AcceptService acceptService;


    /**
     * 查询分页显示
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/find")
    @ResponseBody//转json格式
    public ResultMap<List<Delivery>> findAll(Page page, @RequestParam("limit") int limit){

        page.setRows(limit);

        List<Delivery> deliveryList= deliveryService.findAll(page);

        int total=deliveryService.findTotal(page);

        page.setTotalRecord(total);

        return new ResultMap<List<Delivery>>("",deliveryList,0,total);
    }

    /**
     * 删除操作（rest风格）
     * @param psId
     * @return
     */
    @RequestMapping("/del/{psId}")
    public String delDelivery(@PathVariable("psId") String psId){

        deliveryService.delDelivery(psId);
        return "delivery";
    }

    /**
     * 修改操作
     * @param delivery
     * @return
     */
    @RequestMapping("/upd")
    @ResponseBody
    public String updDelivery(@RequestBody Delivery delivery){

        deliveryService.updDelivery(delivery);
        return "";
    }

    /**
     * 转发到查询存储页面
     * @return
     */
    @RequestMapping("/page")
    public String page1(){
        return "delivery";
    }


    /**
     * 转发到添加页面
     * @return
     */
    @RequestMapping("/page2")
    public String page2(){
        return "adddelivery";
    }



    /**
     * 得到所有的用户名和id
     * @return
     */
    @RequestMapping("/staff")
    @ResponseBody
    public List<Staff> getStaffName(){

        return staffService.getStaffName();
    }

    @RequestMapping("/wh")
    @ResponseBody
    public List<Warehouse> getWarehouse(){

        return warehouseService.findIdName();
    }

    @RequestMapping("/accept")
    @ResponseBody
    public List<Accept> getAcceptName(){

        return acceptService.findAllID_Name();
    }


    @RequestMapping("/add")
    @ResponseBody
    public String addDelivery(@RequestBody Delivery delivery){

        deliveryService.addDelivery(delivery);

        return "";
    }



}

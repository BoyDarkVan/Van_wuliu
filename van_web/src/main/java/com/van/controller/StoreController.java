package com.van.controller;

import com.van.page.Page;
import com.van.page.ResultMap;
import com.van.pojo.Goods;
import com.van.pojo.Staff;
import com.van.pojo.Store;
import com.van.pojo.Warehouse;
import com.van.service.GoodService;
import com.van.service.StaffService;
import com.van.service.StoreService;
import com.van.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private GoodService goodService;


    /**
     * 查询分页显示
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/findAllStore")
    @ResponseBody//转json格式
    public ResultMap<List<Store>> findAllStore(Page page, @RequestParam("limit") int limit){

        page.setRows(limit);
        List<Store> storeList=storeService.findAllStore(page);

        int total=storeService.findTotal(page);

        page.setTotalRecord(total);

        return new ResultMap<List<Store>>("",storeList,0,total);
    }

    /**
     * 删除操作（rest风格）
     * @param sId
     * @return
     */
    @RequestMapping("/del/{sId}")
    public String delStore(@PathVariable("sId") String sId){
        storeService.delStore(sId);
        return "store";
    }

    /**
     * 修改操作
     * @param store
     * @return
     */
    @RequestMapping("/upd")
    @ResponseBody
    public String updStore(@RequestBody Store store){
        storeService.updStore(store);

        return "";
    }

    /**
     * 转发到查询存储页面
     * @return
     */
    @RequestMapping("/page")
    public String page1(){
        return "store";
    }


    /**
     * 转发到添加页面
     * @return
     */
    @RequestMapping("/page2")
    public String page2(){
        return "addstore";
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

    @RequestMapping("/goods")
    @ResponseBody
    public List<Goods> getGoodsName(){

        return goodService.findIdName();
    }

}

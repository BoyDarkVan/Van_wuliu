package com.van.controller;

import com.van.page.Page;
import com.van.page.ResultMap;
import com.van.pojo.Store;
import com.van.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @RequestMapping("/findAllStore")
    @ResponseBody//转json格式
    public ResultMap<List<Store>> findAllStore(Page page, @RequestParam("limit") int limit){
        page.setRows(limit);
        List<Store> storeList=storeService.findAllStore(page);
        int total=storeService.findtotal(page);

        page.setTotalRecord(total);

        return new ResultMap<List<Store>>("",storeList,0,total);
    }

    @RequestMapping("/del/{sId}")
    public String delstore(@PathVariable("sId") String sId){
        System.out.println(sId);
        storeService.delstore(sId);
        return "store";
    }

    @RequestMapping("/page")
    public String finds(){
        return "store";
    }

}

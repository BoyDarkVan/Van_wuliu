package com.van.controller;

import com.van.page.Page;
import com.van.page.ResultMap;
import com.van.pojo.Goods;
import com.van.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodService goodService;
    //分页查询
    @RequestMapping("/find")
    @ResponseBody
    public ResultMap<List<Goods>> findAllgood(Page page, @RequestParam("limit") int limit){
        page.setRows(limit);
        List<Goods> goodList=goodService.findAllgood(page);
        int total=goodService.findtotal(page);
        System.out.println(total);
        page.setTotalRecord(total);

        return new ResultMap<List<Goods>>("",goodList,0,total);
    }

    //添加
    @RequestMapping("/add")
    @ResponseBody
    public void addGood(@RequestBody Goods goods){
        goodService.addGood(goods);
    }
    //删除
    @RequestMapping("/del/{gId}")
    public String delGood(@PathVariable("gId") String gId){
        goodService.delGood(gId);
        return "goods";
    }
    //修改
    @RequestMapping("/upd")
    @ResponseBody
    public void updGood(@RequestBody Goods goods){
        goodService.updGood(goods);
    }

    //视图
    @RequestMapping("page")
    public String find(){
        return "goods";
    }

    @RequestMapping("addGood")
    public String find2(){
        return "addgoods";
    }

}

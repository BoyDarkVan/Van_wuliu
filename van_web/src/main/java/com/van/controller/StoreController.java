package com.van.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.van.pojo.Staff;
import com.van.pojo.Store;
import com.van.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @RequestMapping("findAllStore")
    public String findAllStore(Model model, @RequestParam(value = "param", required = true, defaultValue = "1") int currentPage){
        PageHelper.startPage(currentPage, 2);

        List<Store> list = storeService.findAllStore();

        PageInfo<Store> pageInfo = new PageInfo<>(list);

        model.addAttribute("storelist", pageInfo.getList());

        if (currentPage < 1) {
            currentPage = 1;
        }
        if (currentPage > pageInfo.getPages()) {
            currentPage = pageInfo.getPages();
        }
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalpage", pageInfo.getPages());

        return "store";
    }


}

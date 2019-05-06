package com.van.controller;

import com.van.page.Page;
import com.van.page.ResultMap;
import com.van.pojo.Accept;
import com.van.service.AcceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/accept")
public class AcceptController {

    @Autowired
    private AcceptService acceptService;

    /**
     * @param page
     * @return
     */
    @RequestMapping("/findAllAccept")
    @ResponseBody
    public ResultMap<List<Accept>> findAllAccept(Page page, @RequestParam(value = "searchtext", required = true, defaultValue = "") String searchtext) {

        page.setRows(2);
        List<Accept> ordersList = acceptService.findAllAccept(page);

        int totals = acceptService.selectPageCount(page);

        page.setTotalRecord(totals);

        return new ResultMap<List<Accept>>("", ordersList, 0, totals);
    }

    /**
     * 跳转页面
     *
     * @return
     */
    @RequestMapping("/page")
    public String show() {
        return "accept";
    }


    /**
     * 修改货单
     *
     * @param accept
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    Accept update(@RequestBody Accept accept) {

        acceptService.updateAccept(accept);

        return accept;
    }


}

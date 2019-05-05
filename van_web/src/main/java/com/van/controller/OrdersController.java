package com.van.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.van.page.Page;
import com.van.page.ResultMap;
import com.van.pojo.Orders;
import com.van.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    /**
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/findAllOrder")
    @ResponseBody
    public ResultMap<List<Orders>> findAllOrder(Page page, @RequestParam("limit") int limit) {

        page.setRows(limit);

        List<Orders> ordersList = orderService.findAllOrders(page);

        int totals = orderService.selectPageCount(page);

        page.setTotalRecord(totals);

        return new ResultMap<List<Orders>>("", ordersList, 0, totals);
    }


}

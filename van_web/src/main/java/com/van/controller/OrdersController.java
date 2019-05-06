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
import org.springframework.web.bind.annotation.*;

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
     * @return
     */
    @RequestMapping("/findAllOrder")
    @ResponseBody
    public ResultMap<List<Orders>> findAllOrder(Page page,@RequestParam(value = "searchtext", required = true ,defaultValue = "") String searchtext) {

        page.setRows(2);
        page.setKeyWord(searchtext);
        List<Orders> ordersList = orderService.findAllOrders(page);

        int totals = orderService.selectPageCount(page);

        page.setTotalRecord(totals);

        return new ResultMap<List<Orders>>("", ordersList, 0, totals);
    }

    /**
     * 跳转页面
     * @return
     */
    @RequestMapping("/page")
    public String show(){
        return "orders";
    }


    /**
     * 修改货单
     * @param orders
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    Orders update(@RequestBody Orders orders) {

        orderService.updateOrder(orders);

        return orders;
    }
}

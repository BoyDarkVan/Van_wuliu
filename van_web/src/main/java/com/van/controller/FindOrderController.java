package com.van.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.van.pojo.Orders;
import com.van.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/find")
public class FindOrderController {

    @Autowired
    private OrderService orderService;
    /**
     * 分页查询所有货单
     */
    @RequestMapping("/findAllOrder")
    public String findOrder(Model model, @RequestParam(value = "param", required = true, defaultValue = "1") int currentPage) {

        PageHelper.startPage(currentPage, 2);

        List<Orders> list = orderService.findAllOrders();

        PageInfo<Orders> pageInfo = new PageInfo<>(list);

        model.addAttribute("orderlist", pageInfo.getList());

        if (currentPage < 1) {
            currentPage = 1;
        }
        if (currentPage > pageInfo.getPages()) {
            currentPage = pageInfo.getPages();
        }
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalpage", pageInfo.getPages());

        return "orders";
    }


}

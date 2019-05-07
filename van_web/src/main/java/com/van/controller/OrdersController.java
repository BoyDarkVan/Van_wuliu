package com.van.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.van.page.Page;
import com.van.page.ResultMap;
import com.van.pojo.*;
import com.van.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private AcceptService acceptService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private GoodService goodService;

    /**
     *
     * @param page
     * @return
     */
    @RequestMapping("/findAllOrder")
    @ResponseBody
    public ResultMap<List<Orders>> findAllOrder(Page page,@RequestParam(value = "searchtext", required = true ,defaultValue = "") String searchtext) {
        System.out.println(searchtext);
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


    @RequestMapping("/get_select_users")
    public @ResponseBody List<Users> get_select_users(){
       List<Users> listuser = usersService.findAllUsers();
       return  listuser;
    }

    @RequestMapping("/get_select_accept")
    public @ResponseBody List<Accept> get_select_accept(){
        List<Accept> listaccept = acceptService.findAllID_Name();
        return  listaccept;
    }

    @RequestMapping("/get_select_staff")
    public @ResponseBody List<Staff> get_select_staff(){
        List<Staff> liststaff = staffService.getStaffName();
        return  liststaff;
    }

    @RequestMapping("/get_select_goods")
    public @ResponseBody List<Goods> get_select_goods(){
        List<Goods> listgoods = goodService.findIdName();
        return  listgoods;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestParam(value = "orderId") String orderId,
                         @RequestParam(value = "orderName") String orderName,
                         @RequestParam(value = "orderPrice") String orderPrice,
                         @RequestParam(value = "users") String userId,
                         @RequestParam(value = "accept") String cptId,
                         @RequestParam(value = "staff") String staffId,
                         @RequestParam(value = "goods") String goodsId){

            Orders orders=new Orders(orderId,orderName,orderPrice,new Users(userId),new Accept(cptId),new Staff(staffId),new Goods(goodsId));

            orderService.updateOrder(orders);
            return  "orders";

    }

}

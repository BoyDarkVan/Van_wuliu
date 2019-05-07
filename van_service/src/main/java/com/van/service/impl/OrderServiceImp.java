package com.van.service.impl;

import com.van.mapper.OrdersMapper;
import com.van.page.Page;
import com.van.pojo.Orders;
import com.van.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Override
    public List<Orders> findAllOrders(Page page) {
        return ordersMapper.findAllOrders(page);
    }

    @Override
    public Integer selectPageCount(Page page) {
        return ordersMapper.queryPageCount(page);
    }

    @Override
    public void updateOrder(Orders orders) {
        ordersMapper.updateOrder(orders);
    }

    @Override
    public void addOrder(Orders orders) {
        orders.setOrderId(UUID.randomUUID().toString());
        ordersMapper.addOrder(orders);
    }
}

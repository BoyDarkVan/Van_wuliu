package com.van.service.impl;

import com.van.mapper.OrdersMapper;
import com.van.pojo.Orders;
import com.van.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Override
    public List<Orders> findAllOrders() {

        return  ordersMapper.findAllOrders();
    }
}

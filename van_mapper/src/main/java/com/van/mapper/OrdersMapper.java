package com.van.mapper;

import com.van.pojo.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapper {


    List<Orders> findAllOrders();

}
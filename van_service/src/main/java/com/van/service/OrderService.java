package com.van.service;

import com.van.page.Page;
import com.van.pojo.Orders;

import java.util.List;

public interface OrderService {
    /**
     * 查询所有货单（分页查询）
     * @return
     */
    List<Orders> findAllOrders(Page page);

    Integer selectPageCount(Page page);
}

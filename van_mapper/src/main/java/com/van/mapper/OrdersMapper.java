package com.van.mapper;

import com.van.page.Page;
import com.van.pojo.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapper {


    List<Orders> findAllOrders(Page page);

    //查询总记录数
    Integer queryPageCount(Page page);

    /**
     * 修改货单
     * @param orders
     */
    void  updateOrder(Orders orders);


}
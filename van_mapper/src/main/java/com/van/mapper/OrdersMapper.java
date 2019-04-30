package com.van.mapper;

import com.van.pojo.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapper {
    long countByExample();

    int deleteByExample();

    int deleteByPrimaryKey(String orderId);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample();

    Orders selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Orders record );

    int updateByExample(@Param("record") Orders record);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}
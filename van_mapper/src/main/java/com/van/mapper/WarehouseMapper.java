package com.van.mapper;

import com.van.pojo.Orders;
import com.van.pojo.Warehouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarehouseMapper {

    List<Warehouse> findAllWarehouse();
}
package com.van.service;

import com.van.pojo.Orders;
import com.van.pojo.Warehouse;

import java.util.List;


/**
 * 仓库业务接口，钟恒把实现类给我写了,可以参照我货单的
 */
public interface WarehouseService {
    /**
     * 查询所有仓库（分页查询）
     * @return
     */
    List<Warehouse> findAllWarehouse();

    /**
     * 添加仓库传一个仓库对象过来
     * @param warehouse
     */
    void  addWarehouse(Warehouse warehouse);
}

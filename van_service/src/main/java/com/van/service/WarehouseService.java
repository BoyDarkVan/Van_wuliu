package com.van.service;

import com.van.page.Page;
import com.van.pojo.Warehouse;

import java.util.List;


/**
 * 仓库业务接口，钟恒把实现类给我写了,可以参照我货单的
 */
public interface WarehouseService {
    //分页查询
    List<Warehouse> findAllWarehouse(Page page);

    Integer findtotal(Page page);

    void delWare(String ck_id);

    //添加仓库传一个仓库对象过来
    void  addWarehouse(Warehouse warehouse);

    //修改
    void updWarehouse(Warehouse warehouse);

}

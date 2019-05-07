package com.van.service.impl;

import com.van.mapper.WarehouseMapper;
import com.van.page.Page;
import com.van.pojo.Warehouse;
import com.van.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WarehouseServiceImp implements WarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public List<Warehouse> findAllWarehouse(Page page) {
        return warehouseMapper.findAllWarehouse(page);
    }

    @Override
    public List<Warehouse> findIdName() {
        return warehouseMapper.findIdName();
    }

    @Override
    public Integer findtotal(Page page) {
        return warehouseMapper.findtotal(page);
    }

    @Override
    public void delWare(String ck_id) {
        warehouseMapper.delWare(ck_id);
    }

    @Override
    public void addWarehouse(Warehouse warehouse) {
        warehouseMapper.addWare(warehouse);
    }

    @Override
    public void updWarehouse(Warehouse warehouse) {
        warehouseMapper.updWare(warehouse);
    }

}

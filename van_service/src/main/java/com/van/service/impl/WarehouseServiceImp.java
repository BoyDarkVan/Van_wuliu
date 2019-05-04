package com.van.service.impl;

import com.van.mapper.WarehouseMapper;
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
    public List<Warehouse> findAllWarehouse() {
        return warehouseMapper.findAllWarehouse();
    }

    @Override
    public void addWarehouse(Warehouse warehouse) {

    }
}

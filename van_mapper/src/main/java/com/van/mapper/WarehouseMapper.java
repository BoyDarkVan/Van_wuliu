package com.van.mapper;

import com.van.page.Page;
import com.van.pojo.Warehouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarehouseMapper {

    List<Warehouse> findAllWarehouse(Page page);

    Integer findtotal(Page page);

    void delWare(@Param("ckId") String ckId);

    void addWare(Warehouse warehouse);

    void updWare(Warehouse warehouse);

}
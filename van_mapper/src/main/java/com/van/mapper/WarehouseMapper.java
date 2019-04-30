package com.van.mapper;

import com.van.pojo.Warehouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarehouseMapper {
    long countByExample();

    int deleteByExample();

    int deleteByPrimaryKey(String ckId);

    int insert(Warehouse record);

    int insertSelective(Warehouse record);

    List<Warehouse> selectByExample();

    Warehouse selectByPrimaryKey(String ckId);

    int updateByExampleSelective(@Param("record") Warehouse record);

    int updateByExample(@Param("record") Warehouse record );

    int updateByPrimaryKeySelective(Warehouse record);

    int updateByPrimaryKey(Warehouse record);
}
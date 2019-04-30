package com.van.mapper;

import com.van.pojo.Delivery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeliveryMapper {
    long countByExample();

    int deleteByExample();

    int deleteByPrimaryKey(String psId);

    int insert(Delivery record);

    int insertSelective(Delivery record);

    List<Delivery> selectByExample();

    Delivery selectByPrimaryKey(String psId);

    int updateByExampleSelective(@Param("record") Delivery record );

    int updateByExample(@Param("record") Delivery record );

    int updateByPrimaryKeySelective(Delivery record);

    int updateByPrimaryKey(Delivery record);
}
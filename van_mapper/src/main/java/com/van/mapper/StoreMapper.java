package com.van.mapper;

import com.van.pojo.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreMapper {
    long countByExample();

    int deleteByExample();

    int deleteByPrimaryKey(String sId);

    int insert(Store record);

    int insertSelective(Store record);

    List<Store> selectByExample();

    Store selectByPrimaryKey(String sId);

    int updateByExampleSelective(@Param("record") Store record);

    int updateByExample(@Param("record") Store record);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
}
package com.van.mapper;

import com.van.pojo.Accept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AcceptMapper {
    long countByExample();

    int deleteByExample();

    int deleteByPrimaryKey(String aptId);

    int insert(Accept record);

    int insertSelective(Accept record);

    List<Accept> selectByExample();

    Accept selectByPrimaryKey(String aptId);

    int updateByExampleSelective(@Param("record") Accept record );

    int updateByExample(@Param("record") Accept record);

    int updateByPrimaryKeySelective(Accept record);

    int updateByPrimaryKey(Accept record);
}
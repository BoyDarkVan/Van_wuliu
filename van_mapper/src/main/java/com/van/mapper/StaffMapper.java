package com.van.mapper;

import com.van.pojo.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffMapper {
    long countByExample();

    int deleteByExample();

    int deleteByPrimaryKey(String stId);

    int insert(Staff record);

    int insertSelective(Staff record);

    List<Staff> selectByExample();

    Staff selectByPrimaryKey(String stId);

    int updateByExampleSelective(@Param("record") Staff record );

    int updateByExample(@Param("record") Staff record );

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
}
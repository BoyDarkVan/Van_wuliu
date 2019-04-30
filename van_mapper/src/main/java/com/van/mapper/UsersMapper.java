package com.van.mapper;

import com.van.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {
    long countByExample();

    int deleteByExample();

    int deleteByPrimaryKey(String userId);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample();

    Users selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") Users record );

    int updateByExample(@Param("record") Users record);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}
package com.van.mapper;

import com.van.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    long countByExample();

    int deleteByExample();

    int deleteByPrimaryKey(String gId);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample();

    Goods selectByPrimaryKey(String gId);

    int updateByExampleSelective(@Param("record") Goods record);

    int updateByExample(@Param("record") Goods record );

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}
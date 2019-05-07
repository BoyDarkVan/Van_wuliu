package com.van.mapper;


import com.van.page.Page;
import com.van.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface GoodsMapper {

    List<Goods> findAllgood(Page page);

    List<Goods> findIdName();

    Integer findtotal(Page page);

    void addGood(Goods goods);

    void delGood(@Param("gId") String gId);

    void updGood(Goods goods);

}
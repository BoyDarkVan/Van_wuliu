package com.van.mapper;

import com.van.page.Page;
import com.van.pojo.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreMapper {

    List<Store> findAllstore(Page page);

    Integer findtotal(Page page);

    void delStore(@Param("sId") String sId);

}
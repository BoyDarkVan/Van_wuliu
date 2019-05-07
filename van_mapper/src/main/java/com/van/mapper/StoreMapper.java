package com.van.mapper;

import com.van.page.Page;
import com.van.pojo.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreMapper {

    List<Store> findAllStore(Page page);

    Integer findTotal(Page page);

    void delStore(@Param("sId") String sId);

    void updStore(@Param("store") Store store);

    void addStore(Store store);
}
package com.van.mapper;

import com.van.page.Page;
import com.van.pojo.Delivery;
import com.van.pojo.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeliveryMapper {

    List<Delivery> findAll(Page page);

    Integer findTotal(Page page);

    void delDelivery(@Param("psId") String psId);

    void addDelivery(Delivery delivery);

    void updDelivery(Delivery delivery);
}
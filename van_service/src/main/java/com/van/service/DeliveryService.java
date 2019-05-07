package com.van.service;

import com.van.page.Page;
import com.van.pojo.Delivery;

import java.util.List;

public interface DeliveryService {

    /**
     * 查询所有配送信息（分页查询）
     * @return
     */
    List<Delivery> findAll(Page page);

    Integer findTotal(Page page);

    /**
     * 删除配送信息
     * @param ps_id
     */
    void delDelivery(String ps_id);


    /**
     * 添加配送信息
     * @param delivery
     */
    void  addDelivery(Delivery delivery);


    //  更新配送信息
    void updDelivery(Delivery delivery);
}

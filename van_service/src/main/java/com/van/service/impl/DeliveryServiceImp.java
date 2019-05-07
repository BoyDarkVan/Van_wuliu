package com.van.service.impl;

import com.van.mapper.DeliveryMapper;
import com.van.page.Page;
import com.van.pojo.Delivery;
import com.van.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImp implements DeliveryService {


    @Autowired
    private DeliveryMapper deliveryMapper;

    @Override
    public List<Delivery> findAll(Page page) {
        return deliveryMapper.findAll(page);
    }

    @Override
    public Integer findTotal(Page page) {
        return deliveryMapper.findTotal(page);
    }

    @Override
    public void delDelivery(String ps_id) {
        deliveryMapper.delDelivery(ps_id);
    }

    @Override
    public void addDelivery(Delivery delivery) {
        deliveryMapper.addDelivery(delivery);
    }

    @Override
    public void updDelivery(Delivery delivery) {
        deliveryMapper.updDelivery(delivery);
    }
}

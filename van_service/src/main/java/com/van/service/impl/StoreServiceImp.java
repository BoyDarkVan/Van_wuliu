package com.van.service.impl;

import com.van.mapper.StoreMapper;
import com.van.page.Page;
import com.van.pojo.Store;
import com.van.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImp implements StoreService {

    @Autowired
    private StoreMapper storeMapper;
    @Override
    //分页查询储存信息
    public List<Store> findAllStore(Page page) {
        return storeMapper.findAllstore(page);
    }

    @Override
    public Integer findtotal(Page page) {
        return storeMapper.findtotal(page);
    }

    @Override
    public void delstore(String s_id) {
        storeMapper.delStore(s_id);
    }

    @Override
    public void addStore(Store store) {

    }
}

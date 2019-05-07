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
        return storeMapper.findAllStore(page);
    }

    @Override
    public Integer findTotal(Page page) {
        return storeMapper.findTotal(page);
    }

    @Override
    public void delStore(String s_id) {
        storeMapper.delStore(s_id);
    }

    @Override
    public void addStore(Store store) {
        storeMapper.addStore(store);
    }

    @Override
    public void updStore(Store store) {
        storeMapper.updStore(store);
    }
}

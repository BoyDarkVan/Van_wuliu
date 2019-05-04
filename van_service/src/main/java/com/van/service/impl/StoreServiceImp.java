package com.van.service.impl;

import com.van.mapper.StoreMapper;
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
    public List<Store> findAllStore() {
        return storeMapper.findAllstore();
    }

    @Override
    public void addStore(Store store) {

    }
}

package com.van.service.impl;

import com.van.mapper.GoodsMapper;
import com.van.page.Page;
import com.van.pojo.Goods;
import com.van.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImp implements GoodService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> findAllgood(Page page) {
        return goodsMapper.findAllgood(page);
    }

    @Override
    public List<Goods> findIdName() {
        return goodsMapper.findIdName();
    }

    @Override
    public Integer findtotal(Page page) {
        return goodsMapper.findtotal(page);
    }

    @Override
    public void addGood(Goods goods) {
        goodsMapper.addGood(goods);
    }

    @Override
    public void delGood(String gId) {
        goodsMapper.delGood(gId);
    }

    @Override
    public void updGood(Goods goods) {
        goodsMapper.updGood(goods);
    }

}

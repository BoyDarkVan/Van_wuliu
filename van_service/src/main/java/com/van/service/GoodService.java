package com.van.service;

import com.van.page.Page;
import com.van.pojo.Goods;

import java.util.List;

public interface GoodService {

    List<Goods> findAllgood(Page page);

    List<Goods> findIdName();

    Integer findtotal(Page page);

    void addGood(Goods goods);

    void delGood(String gId);

    void updGood(Goods goods);

}

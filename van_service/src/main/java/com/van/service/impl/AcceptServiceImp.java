package com.van.service.impl;

import com.van.mapper.AcceptMapper;
import com.van.page.Page;
import com.van.pojo.Accept;
import com.van.service.AcceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AcceptServiceImp implements AcceptService {

    @Autowired
    private AcceptMapper acceptMapper;

    @Override
    public List<Accept> findAllID_Name() {
        return acceptMapper.findAllID_Name();
    }

    @Override
    public List<Accept> findAllAccept(Page page) {
        return acceptMapper.findAllAccept(page);
    }

    @Override
    public Integer selectPageCount(Page page) {
        return acceptMapper.queryPageCount(page);
    }

    @Override
    public void updateAccept(Accept accept) {
        acceptMapper.updateAccept(accept);
    }

    @Override
    public void addAccept(Accept accept) {
        acceptMapper.addAccept(accept);
    }
}

package com.van.service.impl;

import com.van.mapper.AdminMapper;
import com.van.pojo.Admin;
import com.van.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin loginAdmin(Admin admin) {
        return adminMapper.loginAdmin(admin);
    }

    @Override
    public void updAdm(String adm_id, String adm_pwd) {
        adminMapper.updAdm(adm_id, adm_pwd);
    }

    @Override
    public void addAdm(String adm_id, String adm_name, String adm_pwd) {
         adminMapper.addAdm(adm_id, adm_name, adm_pwd);
    }

}

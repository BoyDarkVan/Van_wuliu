package com.van.mapper;

import com.van.pojo.Admin;

public interface AdminMapper {
    Admin loginAdmin(Admin admin);

    int updAdm(String adm_id,String adm_pwd);

    int addAdm(String adm_id,String adm_name,String adm_pwd);
}

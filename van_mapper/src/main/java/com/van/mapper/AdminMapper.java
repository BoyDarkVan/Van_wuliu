package com.van.mapper;

import com.van.pojo.Admin;

public interface AdminMapper {

    Admin loginAdmin(Admin admin);

    void updAdm(String adm_id,String adm_pwd);

    void addAdm(String adm_id,String adm_name,String adm_pwd);


}

package com.van.service;

import com.van.page.Page;
import com.van.pojo.Staff;

import java.util.List;


/**
 * 仓库业务接口
 */
public interface StaffService {
    //（分页查询）
    List<Staff> findAllStaff(Page page);

    //查总记录
    Integer findPagetotal(Page page);

    //添加
    void  addStaff(Staff staff);

    //删除
    void deleteStaff(String st_id);

    void updStaff(Staff staff);

}

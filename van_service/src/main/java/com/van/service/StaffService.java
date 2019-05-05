package com.van.service;

import com.van.page.Page;
import com.van.pojo.Staff;
import com.van.pojo.Store;
import com.van.pojo.Warehouse;

import java.util.List;


/**
 * 仓库业务接口，钟恒把实现类给我写了,可以参照我货单的
 */
public interface StaffService {
    /**
     * 查询所有司机信息（分页查询）
     * @return
     */
    List<Staff> findAllStaff(Page page);

    /**
     * 添加仓库传一个司机对象过来
     * @param staff
     */
    void  addStaff(Staff staff);

    //总记录
    Integer findPagetotal(Page page);

    //删除
    void deleteStaff(String st_id);
    

}

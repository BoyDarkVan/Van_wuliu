package com.van.mapper;

import com.van.page.Page;
import com.van.pojo.Staff;

import java.util.List;

public interface StaffMapper {

    List<Staff> findAllStaff(Page page);

    Integer findPagetotal(Page page);

}
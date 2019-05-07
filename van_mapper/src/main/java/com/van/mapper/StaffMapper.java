package com.van.mapper;

import com.van.page.Page;
import com.van.pojo.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffMapper {

    List<Staff> findAllStaff(Page page);

    Integer findPagetotal(Page page);

    void deleteStaff(@Param("stId") String stId);

    void addStaff(Staff staff);

    void updStaff(Staff staff);

    List<Staff> getStaffName();

}
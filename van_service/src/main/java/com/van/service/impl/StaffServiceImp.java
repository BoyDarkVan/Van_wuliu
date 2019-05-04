package com.van.service.impl;

import com.van.mapper.StaffMapper;
import com.van.pojo.Staff;
import com.van.service.StaffService;

import java.util.List;

public class StaffServiceImp implements StaffService {

    private StaffMapper staffMapper;

    @Override
    public List<Staff> findAllStaff() {
        return staffMapper.findAllStaff();
    }

    @Override
    public void addStaff(Staff staff) {

    }
}

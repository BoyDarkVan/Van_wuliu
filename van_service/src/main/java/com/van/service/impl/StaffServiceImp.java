package com.van.service.impl;

import com.van.mapper.StaffMapper;
import com.van.pojo.Staff;
import com.van.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImp implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public List<Staff> findAllStaff() {
        return staffMapper.findAllStaff();
    }

    @Override
    public void addStaff(Staff staff) {

    }
}

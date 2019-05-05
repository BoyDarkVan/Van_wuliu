package com.van.service.impl;

import com.van.mapper.StaffMapper;
import com.van.page.Page;
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
    public List<Staff> findAllStaff(Page page) {
        return staffMapper.findAllStaff(page);
    }

    @Override
    public void addStaff(Staff staff) {

    }

    @Override
    public Integer findPagetotal(Page page) {
        return staffMapper.findPagetotal(page);
    }

    @Override
    public void deleteStaff(String st_id) {
        staffMapper.deleteStaff(st_id);
    }
}

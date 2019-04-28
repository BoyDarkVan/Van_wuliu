package com.van.service.serviceimp;


import com.van.mapper.AdminDAO;
import com.van.mapper.StudentDAO;
import com.van.moudle.Admin;
import com.van.moudle.Student;
import com.van.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private  StudentDAO studentDAO;
    @Autowired
    private AdminDAO adminDAO;


    @Override
    @Transactional
    public List<Student> findAll() {
        return studentDAO.findAll();
    }
    @Override
    @Transactional
    public Student findone(String id) {
        return studentDAO.findone(id);
    }

    @Override
    public void update(Student stu) {
        studentDAO.update(stu);
    }

    @Override
    public Admin login(Admin admin) {
        return adminDAO.login(admin);
    }

}

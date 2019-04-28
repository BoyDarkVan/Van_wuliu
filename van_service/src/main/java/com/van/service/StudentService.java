package com.van.service;

import com.van.moudle.Admin;
import com.van.moudle.Student;

import java.sql.Struct;
import java.util.List;

public interface StudentService {

      List<Student> findAll();

      Student findone(String id);

      void  update(Student stu);


      Admin login(Admin admin);

}

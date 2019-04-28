package com.van.mapper;

import com.van.moudle.Student;
import java.util.List;

public interface StudentDAO {

     List<Student> findAll();

     Student findone(String id);

     void update(Student stu);

}

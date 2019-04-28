package com.van.controller;

import com.van.moudle.Student;
import com.van.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/stu")
public class StudentController {
    @Autowired
    private StudentService studentService;
    /**
     * 查找所有学生
     *
     * @return
     */
    @RequestMapping(value = "/findAll")
    public String test(Model model) {
        List<Student> list = studentService.findAll();
        model.addAttribute("list", list);
        return "show";
    }

    @RequestMapping(value = "/findone/{id}")
    public String findone(@PathVariable String id, Model model) {
        Student stu = studentService.findone(id);
        model.addAttribute("stu", stu);
        return "update";
    }

    @RequestMapping(value = "/update")
    public String update(Student stu, Model model) {
        studentService.update(stu);
        System.out.println("update success");
        return test(model);
    }


    @RequestMapping(value = "/testJson", method = RequestMethod.POST)
    public @ResponseBody
    Student testJson(@RequestBody Student stu) {

        System.out.println(stu);

        return stu;
    }


    @RequestMapping(value = "/testJsonArry", method = RequestMethod.POST)
    public @ResponseBody
    List<Student> testJsonArry(@RequestBody List<Student> stulist) {
        for (Student student : stulist) {
            System.out.println(student);
        }
        return stulist;
    }


    @RequestMapping(value = "/testComplexJsonArry", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> testComplexJsonArry(@RequestBody Map<String, Object> list) {

        for (String s : list.keySet()) {
            System.out.println(list.get(s));
        }
        return list;
    }

    /**
     * 测试必须传参
     *
     * @param param
     */
    @RequestMapping(value = "/RequestParam")                                 /*可设默认参数值*/
    public void RequestParam(@RequestParam(value = "param", required = true /*defaultValue = "30"*/) int param) {
        System.out.println(param);
    }

    /**
     * 转到错误页面
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String myselfException(Exception e, Model modle) {
        modle.addAttribute("message",e);
        return "Erro";
    }

}


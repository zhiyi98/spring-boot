package com.springboot.controller;

import com.springboot.entity.Student;
import com.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @GetMapping("/queryBySno")
  public Student queryBySno(String Sno) {
    Student student = this.studentService.queryStudentBySno(Sno);
    System.out.println("学号" + student.getSno() + "的学生姓名为：" + student.getName());
    return student;
  }

  @PostMapping("/updateBySno")
  public String updateBySno(@RequestBody Student student) {
    Student stu = this.studentService.queryStudentBySno(student.getSno());
    System.out.println("学号" + stu.getSno() + "的学生姓名为：" + stu.getName());
    this.studentService.update(student);
    return "success";
  }

}

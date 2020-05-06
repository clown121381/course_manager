package com.web.framework.course_manager.service;

import com.web.framework.course_manager.entity.Course;
import com.web.framework.course_manager.entity.Student;
import com.web.framework.course_manager.entity.Teacher;
import com.web.framework.course_manager.util.StudentParam;
import org.apache.catalina.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestList {
    @Autowired
    private ManagerStudentsService managerStudentsService;
    @Autowired
    private ManagerTeacherService managerTeacherService;
    @Autowired
    private ManagerCourseService managerCourseService;
    
    @Test
    public void test1(){
        List<Student> list = managerStudentsService.getAllStudentsService();

        System.out.println(list);
    }
    @Test
    public void test2(){
        List<Teacher> list = managerTeacherService.getAllTeacherService();
        System.out.println(list);
    }
    @Test
    public void test3(){
        List<Course> list = managerCourseService.getAllCourseService();
        System.out.println(list);
    }
    @Test
    public void test4(){
        List<StudentParam> list = managerCourseService.getCourseStudentsService(9);
        System.out.println(list);
    }
}

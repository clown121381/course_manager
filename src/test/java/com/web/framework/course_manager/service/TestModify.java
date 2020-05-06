package com.web.framework.course_manager.service;

import com.web.framework.course_manager.entity.Student;
import com.web.framework.course_manager.util.StudentParam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestModify {
    @Autowired
    private ManagerStudentsService managerStudentsService;
    @Test
    public void test1(){
        int i = managerStudentsService.updateStudentService(new StudentParam().setName("zhangsan").setSchoolNumber("2017214213"));
        System.out.println(i);
    }

    @Test
    public void test2(){
        int i = managerStudentsService.deleteStudentService(new StudentParam().setSchoolNumber("2017224417"));
        System.out.println(i);
    }
}

package com.web.framework.course_manager.service;

import com.web.framework.course_manager.entity.Teacher;
import com.web.framework.course_manager.resposity.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestImport {

    @Autowired
    private ImportStudentsService importStudentsService;
    @Autowired
    private TeacherRepository teacherRepository;
    /**
     * 测试学生导入
     */
    @Test
    public void test1(){
        Teacher t = teacherRepository.findTeacherBySchoolNumber("1020090008");
        System.out.println(t);
    }
}

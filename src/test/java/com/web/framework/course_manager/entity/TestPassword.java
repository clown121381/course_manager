package com.web.framework.course_manager.entity;

import com.web.framework.course_manager.resposity.StudentRepository;
import com.web.framework.course_manager.resposity.TeacherRepository;
import com.web.framework.course_manager.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestPassword {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private LoginService loginService;

    @Test
    public void test1(){
        String encode = passwordEncoder.encode("2017214213");
        boolean b = passwordEncoder.matches("2017214213",encode);
        System.out.println(b);
    }

    @Test
    public void test2(){
        List<Student> stus = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String encode = passwordEncoder.encode("201721421"+(4+i));
            Student student = new Student();
            student.setSchoolNumber("201721421"+(4+i)).setPassword(encode).setName("zhangsi");
            stus.add(student);
        }
        studentRepository.saveAll(stus);
    }

    @Test
    public void test3(){
        List<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String encode = passwordEncoder.encode("200821421"+(i));
            Teacher teacher = new Teacher();
            teacher.setSchoolNumber("200821421"+(i)).setPassword(encode).setName("zhangsan");
            teachers.add(teacher);
        }
        teacherRepository.saveAll(teachers);
    }

}

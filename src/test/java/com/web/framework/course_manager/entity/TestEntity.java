package com.web.framework.course_manager.entity;

import com.web.framework.course_manager.resposity.StudentResposity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
public class TestEntity {

    @Autowired
    private StudentResposity studentResposity;

    @Test
    public void testAdd(){
        Student student = new Student();
        student.setName("zhangsan").setSchoolNumber("2017214213");
        studentResposity.save(student);
    }
}

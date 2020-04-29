package com.web.framework.course_manager.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestImport {

    @Autowired
    private ImportStudentsService importStudentsService;
    /**
     * 测试学生导入
     */
    @Test
    public void test1(){

//        importStudentsService.doImportStudentService();
    }
}

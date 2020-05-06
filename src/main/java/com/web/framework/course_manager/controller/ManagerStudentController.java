package com.web.framework.course_manager.controller;

import com.web.framework.course_manager.entity.Student;
import com.web.framework.course_manager.service.ManagerStudentsService;
import com.web.framework.course_manager.util.ResponseMessage;
import com.web.framework.course_manager.util.StudentParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerStudentController {
    @Autowired
    private ManagerStudentsService managerStudentsService;

    @GetMapping("/api/listStudents")
    public ResponseMessage listStudents(){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setRequestflag(true);
        responseMessage.setCode(200);
        List<Student> allStudentsService = managerStudentsService.getAllStudentsService();
        responseMessage.setData(allStudentsService);
        responseMessage.setMessage("查询学生成功");
        return responseMessage;
    }

    @PostMapping("/api/addStudent")
    public ResponseMessage addStudent(@RequestBody StudentParam studentParam){
        ResponseMessage responseMessage = new ResponseMessage();
        Student student = managerStudentsService.addStudentService(studentParam);
        if(student != null){
            responseMessage.setCode(200);
            responseMessage.setRequestflag(true);
            responseMessage.setMessage("添加学生成功");
        }
        return responseMessage;
    }

    @PostMapping("/api/updateStudent")
    public ResponseMessage updateStudent(@RequestBody StudentParam studentParam){
        ResponseMessage responseMessage = new ResponseMessage();
        int i = managerStudentsService.updateStudentService(studentParam);
        if (i > 0){
            responseMessage.setRequestflag(true);
            responseMessage.setMessage("更新学生成功");
            return responseMessage;
        }
        responseMessage.setRequestflag(false);
        responseMessage.setMessage("更新学生失败");
        return responseMessage;
    }

    @PostMapping("/api/deleteStudent")
    public ResponseMessage deleteStudent(@RequestBody StudentParam studentParam){
        ResponseMessage responseMessage = new ResponseMessage();
        int i = managerStudentsService.deleteStudentService(studentParam);
        if (i > 0){
            responseMessage.setRequestflag(true);
            responseMessage.setMessage("删除学生成功");
            return responseMessage;
        }
        responseMessage.setRequestflag(false);
        responseMessage.setMessage("删除学生失败");
        return responseMessage;
    }
}

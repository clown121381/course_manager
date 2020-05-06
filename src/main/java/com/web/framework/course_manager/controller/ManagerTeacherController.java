package com.web.framework.course_manager.controller;

import com.web.framework.course_manager.entity.Teacher;
import com.web.framework.course_manager.service.ManagerTeacherService;
import com.web.framework.course_manager.util.ResponseMessage;
import com.web.framework.course_manager.util.TeacherParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerTeacherController {
    @Autowired
    private ManagerTeacherService managerTeacherService;

    @GetMapping("/api/listTeachers")
    public ResponseMessage listTeachers(){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setRequestflag(true);
        responseMessage.setCode(200);
        List<Teacher> allStudentsService = managerTeacherService.getAllTeacherService();
        responseMessage.setData(allStudentsService);
        responseMessage.setMessage("查询教师成功");
        return responseMessage;
    }
    @PostMapping("/api/addTeacher")
    public ResponseMessage addTeacher(@RequestBody TeacherParam teacherParam){
        ResponseMessage responseMessage = new ResponseMessage();
        Teacher teacher = managerTeacherService.addTeacherService(teacherParam);
        if(teacher != null){
            responseMessage.setCode(200);
            responseMessage.setRequestflag(true);
            responseMessage.setMessage("添加教师成功");
        }
        return responseMessage;
    }
    @PostMapping("/api/updateTeacher")
    public ResponseMessage updateTeacher(@RequestBody TeacherParam teacherParam){
        ResponseMessage responseMessage = new ResponseMessage();
        int i = managerTeacherService.updateTeacherService(teacherParam);
        if (i > 0){
            responseMessage.setRequestflag(true);
            responseMessage.setMessage("更新教师成功");
            return responseMessage;
        }
        responseMessage.setRequestflag(false);
        responseMessage.setMessage("更新教师失败");
        return responseMessage;

    }
    @PostMapping("/api/deleteTeacher")
    public ResponseMessage deleteTeacher(@RequestBody TeacherParam teacherParam){
        ResponseMessage responseMessage = new ResponseMessage();
        int i = managerTeacherService.deleteTeacherService(teacherParam);
        if (i > 0){
            responseMessage.setRequestflag(true);
            responseMessage.setMessage("删除教师成功");
            return responseMessage;
        }
        responseMessage.setRequestflag(false);
        responseMessage.setMessage("删除教师失败");
        return responseMessage;
    }
}

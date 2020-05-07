package com.web.framework.course_manager.controller;

import com.web.framework.course_manager.entity.Course;
import com.web.framework.course_manager.entity.Design;
import com.web.framework.course_manager.entity.Student;
import com.web.framework.course_manager.entity.Teacher;
import com.web.framework.course_manager.service.DesignService;
import com.web.framework.course_manager.service.ManagerCourseService;
import com.web.framework.course_manager.util.ChooseParam;
import com.web.framework.course_manager.util.ResponseMessage;
import com.web.framework.course_manager.util.StartChooseParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DesignController {

    @Autowired
    private DesignService designService;
    @Autowired
    private ManagerCourseService managerCourseService;
    @Autowired
    private ServletContext application;

    @GetMapping("/api/listDesginSubjects")
    public ResponseMessage listDesginSubjects(){
        ResponseMessage responseMessage = new ResponseMessage();
        List<Design> designSubjects = designService.findAllDesignSubjects();
        responseMessage.setRequestflag(true);
        responseMessage.setData(designSubjects);
        return responseMessage;
    }

    @GetMapping("/api/listTeacherCourses")
    public ResponseMessage listTeacherCourses(HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        ResponseMessage responseMessage = new ResponseMessage();
        if(teacher == null){
            responseMessage.setRequestflag(false);
            responseMessage.setMessage("当前教师未登录");
            return responseMessage;
        }
        List<Course> courses = managerCourseService.getTeacherCourseService(teacher.getId());
        responseMessage.setRequestflag(true);
        responseMessage.setData(courses);
        return responseMessage;
    }

    @PostMapping(value = "/api/startChoose",
                    produces = {"application/json;charset=UTF-8"})
    public ResponseMessage startChooseController(@RequestBody StartChooseParam startChooseParam, HttpSession session){
        ResponseMessage responseMessage = new ResponseMessage();
        List<Integer> list = new ArrayList<>(startChooseParam.getCourses().length);
        for (int cours : startChooseParam.getCourses()) {
            list.add(cours);
        }
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        designService.startChoose(application,list,startChooseParam.getNumber(),teacher);
        responseMessage.setMessage("启动互选成功");
        responseMessage.setRequestflag(true);
        return responseMessage;
    }

    @PostMapping("/api/chooseTeacher")
    public ResponseMessage chooseTeacher(HttpSession session,@RequestBody ChooseParam chooseParam){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setRequestflag(true);
        Student student = (Student)session.getAttribute("student");
        if(student == null){
            responseMessage.setRequestflag(true);
            responseMessage.setMessage("学生未登录");
            return responseMessage;
        }
        boolean b = designService.chooseTeacher(application,chooseParam.getDesignId(),chooseParam.getTeacherId(),student);
        if(b) {
            responseMessage.setMessage("选择导师成功");
            return responseMessage;
        }
        responseMessage.setMessage("选择导师失败");
        return responseMessage;
    }
    @GetMapping("/api/listChooseOfTeachers")
    public ResponseMessage listChooseOfTeachers(){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setRequestflag(true);
        responseMessage.setCode(200);
        Object allStudentsService = application.getAttribute("beginList");
        if(allStudentsService != null){
            responseMessage.setData((List<Teacher>)allStudentsService);
        }
        responseMessage.setMessage("查询教师成功");
        return responseMessage;
    }

}

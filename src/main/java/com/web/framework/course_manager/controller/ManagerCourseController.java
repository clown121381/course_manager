package com.web.framework.course_manager.controller;

import com.web.framework.course_manager.entity.Course;
import com.web.framework.course_manager.entity.S_C_ManyToMany;
import com.web.framework.course_manager.entity.Student;
import com.web.framework.course_manager.service.ManagerCourseService;
import com.web.framework.course_manager.util.CourseParam;
import com.web.framework.course_manager.util.ResponseMessage;
import com.web.framework.course_manager.util.ScParam;
import com.web.framework.course_manager.util.StudentParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerCourseController {

    @Autowired
    private ManagerCourseService managerCourseService;

    @GetMapping("/api/listCourses")
    public ResponseMessage listConures(){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setRequestflag(true);
        responseMessage.setCode(200);
        List<Course> allCourseService = managerCourseService.getAllCourseService();
        responseMessage.setData(allCourseService);
        responseMessage.setMessage("查询课程成功");
        return responseMessage;
    }
    @GetMapping("/api/getCourseStudents/{id}")
    public ResponseMessage getCourseStudents(@PathVariable int id){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setRequestflag(true);
        responseMessage.setCode(200);
        List<StudentParam> courseStudents = managerCourseService.getCourseStudentsService(id);
        responseMessage.setData(courseStudents);
        responseMessage.setMessage("查询成功");
        return responseMessage;
    }

    @GetMapping("/api/deleteCourse/{id}")
    public ResponseMessage deleteCourse(@PathVariable int id){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setRequestflag(true);
        responseMessage.setCode(200);
        managerCourseService.deleteCourseService(id);
        responseMessage.setMessage("删除课程成功");
        return responseMessage;
    }
    @PostMapping("/api/deleteCourseStudent")
    public ResponseMessage deleteCourseStudent(@RequestBody ScParam scParam){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setRequestflag(true);
        responseMessage.setCode(200);
        int i = managerCourseService.deleteCourseStudentService(scParam);
        if (i > 0) {
            responseMessage.setMessage("删除学生成功");
            return responseMessage;
        }
        responseMessage.setMessage("删除学生失败");
        return responseMessage;
    }

    @PostMapping("/api/addCourseStudent")
    public ResponseMessage addCourseStudent(@RequestBody ScParam scParam){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setRequestflag(true);
        responseMessage.setCode(200);
        S_C_ManyToMany student = managerCourseService.addCourseStudentService(scParam);
        if (student != null) {
            responseMessage.setMessage("添加学生成功");
            return responseMessage;
        }
        responseMessage.setMessage("添加学生失败");
        return responseMessage;
    }

    @PostMapping("/api/updateCourseStudent")
    public ResponseMessage updateCourseStudent(@RequestBody ScParam scParam){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setRequestflag(true);
        responseMessage.setCode(200);
        int i =  managerCourseService.updateCourseStudentService(scParam);
        responseMessage.setMessage("更新学生成功");
        return responseMessage;
    }

    @PostMapping("/api/updateCourse")
    public ResponseMessage updateCourse(@RequestBody CourseParam courseParam){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setRequestflag(true);
        responseMessage.setCode(200);
        int i =  managerCourseService.updateCourseService(courseParam);
        responseMessage.setMessage("更新课程成功");
        return responseMessage;
    }

    @PostMapping("/api/addCourse")
    public ResponseMessage addCourse(@RequestBody CourseParam courseParam){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setRequestflag(true);
        responseMessage.setCode(200);
        Course c =  managerCourseService.addCourseService(courseParam);
        if(c != null){
            responseMessage.setMessage("添加课程成功");
            return responseMessage;
        }
        responseMessage.setMessage("添加课程失败");
        return responseMessage;
    }
}

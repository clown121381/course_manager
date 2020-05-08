package com.web.framework.course_manager.controller;

import com.web.framework.course_manager.entity.Student;
import com.web.framework.course_manager.entity.Teacher;
import com.web.framework.course_manager.service.LoginService;
import com.web.framework.course_manager.util.LoginParam;
import com.web.framework.course_manager.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @RequestMapping("/api/login")
    public Object doLogin(HttpSession session, @RequestBody LoginParam loginParam){
        System.out.println(loginParam);
        String type = loginParam.getType();
        ResponseMessage responseMessage = new ResponseMessage();
        // 学生登陆
        if("student".equals(type)){
            Student s1 = (Student) session.getAttribute("student");
            if(s1 != null){
                responseMessage.setRequestflag(true);
                responseMessage.setMessage("已经登陆过了");
                responseMessage.setData(s1);
                return responseMessage;
            }

            responseMessage.setCode(200);
            String schoolNumber = loginParam.getSchoolNumber();
            String password = loginParam.getPassword();
            Student student = loginService.doStudentsLogin(schoolNumber,password);
            if(student != null){
                responseMessage.setData(student);
                responseMessage.setMessage("学生的登陆成功");
                responseMessage.setRequestflag(true);
                session.setAttribute("student",student);
            }else{
                responseMessage.setMessage("没有找到该学生");
                responseMessage.setRequestflag(false);
            }
        }else if("teacher".equals(type)){
        //教师登录
            Teacher t1 = (Teacher) session.getAttribute("teacher");
            if(t1 != null){
                responseMessage.setRequestflag(true);
                responseMessage.setMessage("已经登陆过了");
                responseMessage.setData(t1);
                return responseMessage;
            }

            responseMessage.setCode(200);
            String schoolNumber = loginParam.getSchoolNumber();
            String password = loginParam.getPassword();
            Teacher teacher = loginService.doTeachersLogin(schoolNumber,password);
            if(teacher != null){
                responseMessage.setData(teacher);
                responseMessage.setMessage("教师登陆成功");
                responseMessage.setRequestflag(true);
                session.setAttribute("teacher",teacher);
            }else{
                responseMessage.setMessage("没有找到该教师");
                responseMessage.setRequestflag(false);
            }
        }else if("admin".equals(type)){
        //超级管理员登录

        }else {
            responseMessage.setCode(500);
            responseMessage.setMessage("用户类型错误");
            responseMessage.setRequestflag(false);
        }
        return responseMessage;
    }

    @PostMapping("/api/doResetPassword")
    public ResponseMessage resetPassword(HttpSession session,@RequestBody LoginParam loginParam){
        Object obj = session.getAttribute("student");
        ResponseMessage responseMessage = new ResponseMessage();
        if(obj != null){
            Student student = (Student)obj;
            boolean b = loginService.doResetStudentPasswordService(student.getSchoolNumber(),loginParam.getPassword());
            responseMessage.setRequestflag(b);
        }else {
            Teacher teacher = (Teacher)session.getAttribute("teacher");
            boolean b = loginService.doResetTeacherPasswordService(teacher.getSchoolNumber(),loginParam.getPassword());
            responseMessage.setRequestflag(b);
        }
        responseMessage.setMessage("密码修改成功");
        return responseMessage;
    }

    @PostMapping("/api/doCheckPassword")
    public ResponseMessage checkPassword(HttpSession session,@RequestBody LoginParam loginParam){
        Object obj = session.getAttribute("student");
        ResponseMessage responseMessage = new ResponseMessage();
        if(obj != null){
            Student student = (Student)obj;
            boolean b = passwordEncoder.matches(loginParam.getPassword(),student.getPassword());
            responseMessage.setRequestflag(b);
        }else {
            Teacher teacher = (Teacher)session.getAttribute("teacher");
            boolean b = passwordEncoder.matches(loginParam.getPassword(),teacher.getPassword());
            responseMessage.setRequestflag(b);
        }
        responseMessage.setMessage("密码匹配成功");
        return responseMessage;
    }

    @GetMapping("/api/getCurrentUser")
    public ResponseMessage getCurrentUser(HttpSession session){
        Object obj = session.getAttribute("student");
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setRequestflag(true);
        if(obj != null){
            Student student = (Student)obj;
            responseMessage.setData(student);
        }else {
            Teacher teacher = (Teacher)session.getAttribute("teacher");
            responseMessage.setData(teacher);
        }
        responseMessage.setMessage("查询成功");
        return responseMessage;
    }

}

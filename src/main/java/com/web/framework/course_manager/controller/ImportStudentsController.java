package com.web.framework.course_manager.controller;

import com.web.framework.course_manager.entity.Teacher;
import com.web.framework.course_manager.service.ImportStudentsService;
import com.web.framework.course_manager.util.ImportStudentsParam;
import com.web.framework.course_manager.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class ImportStudentsController {

    @Autowired
    private ImportStudentsService importStudentsService;

    @PostMapping("/api/importStudent")
    public ResponseMessage doImportStudentsController(HttpSession session, @RequestBody ImportStudentsParam param){
        ResponseMessage responseMessage = new ResponseMessage();
        //校验教师是否登录
        Teacher t1 = (Teacher) session.getAttribute("teacher");
        if(t1 == null){
            responseMessage.setRequestflag(false);
            responseMessage.setMessage("教师未登录");
            return responseMessage;
        }

        //校验教师传入的信息与session中的信息是否匹配
       boolean b = param.teacher.getSchoolNumber().equals(t1.getSchoolNumber());
        if(b) {
            importStudentsService.doImportStudentService(param);
            responseMessage.setCode(200);
            responseMessage.setRequestflag(true);
            responseMessage.setMessage("上传学生数据成功");
        }else{
            responseMessage.setCode(500);
            responseMessage.setRequestflag(false);
            responseMessage.setMessage("登陆教师与数据表格教师不匹配");
        }
        return responseMessage;
    }
}

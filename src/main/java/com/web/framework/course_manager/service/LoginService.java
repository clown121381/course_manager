package com.web.framework.course_manager.service;

import com.web.framework.course_manager.entity.Student;
import com.web.framework.course_manager.entity.Teacher;
import com.web.framework.course_manager.resposity.StudentRepository;
import com.web.framework.course_manager.resposity.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    
    public Student doStudentsLogin(String schoolNumber,String password){
        String encode = passwordEncoder.encode(password);
        Student student = studentRepository.findStudentBySchoolNumber(schoolNumber);
        //匹配用户名和密码
        if(student != null && passwordEncoder.matches(password,student.getPassword())){
            return student;
        }
        return null;
    }

    public Teacher doTeachersLogin(String schoolNumber,String password){
        String encode = passwordEncoder.encode(password);
        Teacher teacher = teacherRepository.findTeacherBySchoolNumber(schoolNumber);
        //匹配用户名和密码
        if(teacher != null && passwordEncoder.matches(password,teacher.getPassword())){
            return teacher;
        }
        return null;
    }
}

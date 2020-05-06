package com.web.framework.course_manager.service;

import com.web.framework.course_manager.entity.Teacher;
import com.web.framework.course_manager.resposity.TeacherRepository;
import com.web.framework.course_manager.util.TeacherParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ManagerTeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Teacher> getAllTeacherService(){
        Iterable<Teacher> all = teacherRepository.findAll();
        Iterator<Teacher> it = all.iterator();
        List<Teacher> list = new ArrayList<>();
        while (it.hasNext()) {
            list.add(it.next());
        }
        return list;
    }

    public Teacher addTeacherService(TeacherParam teacherParam) {
        Teacher teacher = new Teacher();
        String encode = passwordEncoder.encode(teacherParam.getSchoolNumber());
        teacher.setName(teacherParam.getName())
                .setPassword(encode)
                .setSchoolNumber(teacherParam.getSchoolNumber());
        Teacher t = teacherRepository.save(teacher);

        return t;
    }

    @Transactional
    public int deleteTeacherService(TeacherParam teacherParam){
        String schoolNumber = teacherParam.getSchoolNumber();
        int i = teacherRepository.deleteTeacherBySchoolNumber(schoolNumber);
        return i;
    }

    @Transactional
    public int updateTeacherService(TeacherParam teacherParam) {
        String name = teacherParam.getName();
        String schoolNumber = teacherParam.getSchoolNumber();
        int i = teacherRepository.updateTeacherBySchoolNumber(name, schoolNumber);
        return i;
    }
}

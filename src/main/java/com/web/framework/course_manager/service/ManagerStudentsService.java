package com.web.framework.course_manager.service;

import com.web.framework.course_manager.entity.Student;
import com.web.framework.course_manager.resposity.S_C_ManyToManyRepository;
import com.web.framework.course_manager.resposity.StudentRepository;
import com.web.framework.course_manager.util.StudentParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ManagerStudentsService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private S_C_ManyToManyRepository s_c_manyToManyRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Student> getAllStudentsService(){
        Iterable<Student> students = studentRepository.findAll();
        Iterator<Student> iterator = students.iterator();
        List<Student> list = new ArrayList<>();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }

    public Student addStudentService(StudentParam studentParam){
        Student student = new Student();
        String encode = passwordEncoder.encode(studentParam.getSchoolNumber());
        student.setName(studentParam.getName())
                .setPassword(encode)
                .setSchoolNumber(studentParam.getSchoolNumber());
        Student s = studentRepository.save(student);
        return s;
    }
    
    @Transactional
    public int updateStudentService(StudentParam studentParam){
        String name = studentParam.getName();
        String schoolNumber = studentParam.getSchoolNumber();
        int i = studentRepository.updateStudentBySchoolNumber(name, schoolNumber);
        return i;
    }

    @Transactional
    public int deleteStudentService(StudentParam studentParam){
        String schoolNumber = studentParam.getSchoolNumber();
        int i = studentRepository.deleteStudentBySchoolNumber(schoolNumber);
        return i;
    }
}

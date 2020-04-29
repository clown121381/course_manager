package com.web.framework.course_manager.resposity;

import com.web.framework.course_manager.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends CrudRepository<Student,Integer> {

    Student findStudentBySchoolNumber(String schoolNumber);
}

package com.web.framework.course_manager.resposity;

import com.web.framework.course_manager.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Integer> {

}

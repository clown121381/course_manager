package com.web.framework.course_manager.resposity;

import com.web.framework.course_manager.entity.Course;
import com.web.framework.course_manager.entity.S_C_ManyToMany;
import com.web.framework.course_manager.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface S_C_ManyToManyRepository extends CrudRepository<S_C_ManyToMany,Integer> {

    S_C_ManyToMany findS_C_ManyToManyByCourseAndStudent(Course course,Student student);
}

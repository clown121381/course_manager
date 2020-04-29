package com.web.framework.course_manager.resposity;

import com.web.framework.course_manager.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher,Integer> {
    Teacher findTeacherBySchoolNumber(String schoolNumber);
}

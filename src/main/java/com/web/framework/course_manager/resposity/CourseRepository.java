package com.web.framework.course_manager.resposity;

import com.web.framework.course_manager.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,Integer> {
    public Course findCourseByCourseId(String courseId);
}

package com.web.framework.course_manager.resposity;

import com.web.framework.course_manager.entity.Course;
import com.web.framework.course_manager.entity.Teacher;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course,Integer> {
    @Query(value = "select id,name,teacher_id,weight,course_id,total_score from course where course_id=?1",nativeQuery = true)
    Course getTheCourseByCourseId(String courseId);

    @Modifying
    @Query(value = "update course set name=?1, weight=?2,total_score=?3 where id=?4  ",nativeQuery = true)
    int updateCourse(String name,double weight,String total_score,int id);

    @Modifying
    @Query(value = "insert into course(name,teacher_id,weight,total_score) values(?1,?2,?3,?4)",nativeQuery = true)
    int insertCourse(String name,int teacher_id,double weight,double total_score);

    List<Course> findCoursesByTeacher(Teacher teacher);
}

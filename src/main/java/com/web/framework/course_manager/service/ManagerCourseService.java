package com.web.framework.course_manager.service;

import com.web.framework.course_manager.entity.Course;
import com.web.framework.course_manager.resposity.CourseRepository;
import com.web.framework.course_manager.util.CourseParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ManagerCourseService {
    @Autowired
    public CourseRepository courseRepository;

    public List<Course> getAllCourseService(){
        Iterable<Course> all = courseRepository.findAll();
        Iterator<Course> it = all.iterator();
        List<Course> list = new ArrayList<>();
        while (it.hasNext()){
            list.add(it.next());
        }

        return list;
    }

    public Course addCourseService(CourseParam courseParam){
        Course course = new Course();
        course.setName(courseParam.getName());
        course.setCourseId(courseParam.getCourseId());
        course.setTotalScore(courseParam.getTotalScore());
        course.setWeight(courseParam.getWeight());

        Course c = courseRepository.save(course);
        return c;
    }
}

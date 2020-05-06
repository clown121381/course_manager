package com.web.framework.course_manager.util;

import com.web.framework.course_manager.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScParam {
    private CourseParam course;
    private StudentParam student;
}

package com.web.framework.course_manager.util;

import com.web.framework.course_manager.entity.Course;
import com.web.framework.course_manager.entity.Student;
import com.web.framework.course_manager.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportStudentsParam {
    public TeacherParam teacher;
    public CourseParam course;
    public List<StudentParam> students;
}

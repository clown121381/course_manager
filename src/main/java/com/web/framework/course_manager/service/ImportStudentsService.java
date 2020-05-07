package com.web.framework.course_manager.service;

import com.web.framework.course_manager.entity.Course;
import com.web.framework.course_manager.entity.S_C_ManyToMany;
import com.web.framework.course_manager.entity.Student;
import com.web.framework.course_manager.entity.Teacher;
import com.web.framework.course_manager.resposity.CourseRepository;
import com.web.framework.course_manager.resposity.S_C_ManyToManyRepository;
import com.web.framework.course_manager.resposity.StudentRepository;
import com.web.framework.course_manager.resposity.TeacherRepository;
import com.web.framework.course_manager.util.CourseParam;
import com.web.framework.course_manager.util.ImportStudentsParam;
import com.web.framework.course_manager.util.StudentParam;
import com.web.framework.course_manager.util.TeacherParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 老师导入学生
 */
@Service
public class ImportStudentsService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private S_C_ManyToManyRepository s_c_manyToManyRepository;

    @Transactional
    public boolean doImportStudentService(ImportStudentsParam param){
        TeacherParam teacherParam = param.getTeacher();
        CourseParam courseParam = param.getCourse();
        List<StudentParam> studentsParam = param.getStudents();

        //处理课程信息
        Course course = new Course();
        course.setCourseId(courseParam.getCourseId())
              .setName(courseParam.getName())
              .setTotalScore(courseParam.getTotalScore())
                .setWeight(courseParam.getWeight());

        //处理教师信息,学生和老师的默认账户密码都是学号
        String teacherPassword = passwordEncoder.encode(teacherParam.getSchoolNumber());
        Teacher teacher = new Teacher();
        teacher.setName(teacherParam.getName())
                .setSchoolNumber(teacherParam.getSchoolNumber())
                .setPassword(teacherPassword);


        doImportData(teacher,studentsParam,course);
        return true;
    }

    /**
     * 处理import数据 不存在则添加教师,学生，课程
     * @param teacher
     * @return  返回影响的行数
     */
    @Transactional
    public void doImportData(Teacher teacher,List<StudentParam> studentsParam,Course course){
        //从数据库中查询结果，如果不存在则添加
        Teacher t1 = teacherRepository.findTeacherBySchoolNumber(teacher.getSchoolNumber());
        if(t1 == null){
            //添加教师所任课的课程
            t1 = teacherRepository.save(teacher);
        }
        //再次从数据库中查询课程
        Course c1 = courseRepository.getTheCourseByCourseId(course.getCourseId());
        if(c1 == null) {
            c1 = courseRepository.save(course);
        }

        for (StudentParam studentParam: studentsParam){
            //学生的默认密码也是学号
            String studentPassword = passwordEncoder.encode(studentParam.getSchoolNumber());
            Student student = new Student();
            student.setName(studentParam.getName())
                    .setSchoolNumber(studentParam.getSchoolNumber())
                    .setPassword(studentPassword);

            //添加学生课程关系
            S_C_ManyToMany sc = new S_C_ManyToMany();
            sc.setScore(studentParam.getScore())
                    .setStudent(student)
                    .setCourse(c1);
            //学生
            Student s1 = studentRepository.findStudentBySchoolNumber(student.getSchoolNumber());
            if(s1 == null){
                s1 = studentRepository.save(student);
            }
            //学生课程关系
            S_C_ManyToMany sc1 = s_c_manyToManyRepository.findS_C_ManyToManyByCourseAndStudent(c1,s1);
            if(sc1 == null){
                s_c_manyToManyRepository.insertSc(sc.getScore(),sc.getCourse().getId(),s1.getId());
            }
        }
    }
}

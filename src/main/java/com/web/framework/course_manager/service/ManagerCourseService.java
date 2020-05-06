package com.web.framework.course_manager.service;

import com.web.framework.course_manager.entity.Course;
import com.web.framework.course_manager.entity.S_C_ManyToMany;
import com.web.framework.course_manager.entity.Student;
import com.web.framework.course_manager.entity.Teacher;
import com.web.framework.course_manager.resposity.CourseRepository;
import com.web.framework.course_manager.resposity.S_C_ManyToManyRepository;
import com.web.framework.course_manager.resposity.StudentRepository;
import com.web.framework.course_manager.util.CourseParam;
import com.web.framework.course_manager.util.ScParam;
import com.web.framework.course_manager.util.StudentParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerCourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private S_C_ManyToManyRepository s_c_manyToManyRepository;
    @Autowired
    private ManagerStudentsService managerStudentsService;
    @Autowired
    public StudentRepository studentRepository;
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
        course.setTeacher(new Teacher().setId(courseParam.getTeacher().getId()));
        return courseRepository.save(course);
    }

    public List<StudentParam> getCourseStudentsService(int id) {
        List<S_C_ManyToMany> many = s_c_manyToManyRepository.findS_C_ManyToManyByCourse(new Course().setId(id));
        List<StudentParam> list = new ArrayList<>(many.size());
        for (S_C_ManyToMany m : many) {
            StudentParam studentParam = new StudentParam();
            studentParam.setScore(m.getScore())
                    .setName(m.getStudent().getName())
                    .setSchoolNumber(m.getStudent().getSchoolNumber());
            list.add(studentParam);
        }
        return list;
    }

    @Transactional
    public void deleteCourseService(int id) {
        courseRepository.deleteById(id);
    }

    @Transactional
    public int deleteCourseStudentService(ScParam scParam) {
        Student student = studentRepository.findStudentBySchoolNumber(scParam.getStudent().getSchoolNumber());
        if(student != null){
            int i = s_c_manyToManyRepository.deleteSc(scParam.getCourse().getId(),student.getId());
            return i;
        }
        return 0;
    }

    @Transactional
    public int updateCourseStudentService(ScParam scParam) {
        double score = scParam.getStudent().getScore();
        int courseId = scParam.getCourse().getId();
        String schoolNumber = scParam.getStudent().getSchoolNumber();
        Student student = studentRepository.findStudentBySchoolNumber(schoolNumber);
        int i = s_c_manyToManyRepository.updateSC(score, courseId, student.getId());
        return i;
    }

    public S_C_ManyToMany addCourseStudentService(ScParam scParam) {
        Optional<Course> byId = courseRepository.findById(scParam.getCourse().getId());
        Course course = byId.get();
        S_C_ManyToMany sc = new S_C_ManyToMany();
        sc.setScore(scParam.getStudent().getScore());
        sc.setCourse(course);
        Student student = studentRepository.findStudentBySchoolNumber(scParam.getStudent().getSchoolNumber());
        if(student == null){
            student = managerStudentsService.addStudentService(scParam.getStudent());
        }
        sc.setStudent(student);

        S_C_ManyToMany save = s_c_manyToManyRepository.save(sc);

        return save;
    }

    @Transactional
    public int updateCourseService(CourseParam courseParam) {
        String name = courseParam.getName();
        double weight = courseParam.getWeight();
        String totalScore = courseParam.getTotalScore();
        int id = courseParam.getId();
        int i = courseRepository.updateCourse(name,weight,totalScore,id);
        return i;
    }
}

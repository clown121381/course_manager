package com.web.framework.course_manager.service;

import com.web.framework.course_manager.entity.Course;
import com.web.framework.course_manager.entity.Design;
import com.web.framework.course_manager.entity.Student;
import com.web.framework.course_manager.entity.Teacher;
import com.web.framework.course_manager.resposity.ChooseListRepository;
import com.web.framework.course_manager.resposity.DesignRepository;
import com.web.framework.course_manager.resposity.TeacherRepository;
import com.web.framework.course_manager.util.StudentParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class DesignService {
    @Autowired
    private DesignRepository designRepository;
    @Autowired
    private ManagerCourseService managerCourseService;
    @Autowired
    private ManagerStudentsService managerStudentsService;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ChooseListRepository chooseListRepository;
    public List<Design> findAllDesignSubjects(){
        Iterable<Design> all = designRepository.findAll();
        Iterator<Design> it = all.iterator();
        List<Design> list = new ArrayList<>();
        while (it.hasNext()){
            list.add(it.next());
        }
        return list;
    }

    public void startChoose(ServletContext application, List<Integer> courses, int number, Teacher teacher) {
        List<Course> courseList = managerCourseService.getCourseByIds(courses);
        //学号成绩，多个课程叠加
        Map<String,Double> map = new HashMap<>();
        //学号，加权排序取出前number名学生，放入session
        TreeMap<Double,String> sortMap = new TreeMap<>();

        for (Course course : courseList) {
            List<StudentParam> studentsParam = managerCourseService.getCourseStudentsService(course.getId());
            double weight = course.getWeight();
            for (StudentParam studentParam : studentsParam) {
                double score = studentParam.getScore();
                String schoolNumber = studentParam.getSchoolNumber();
                if(map.get(schoolNumber) == null){
                    map.put(schoolNumber,score*weight);
                }else{
                    map.put(schoolNumber,score*weight + map.get(schoolNumber));
                }
            }
        }
        Iterator<Map.Entry<String, Double>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Double> next = iterator.next();
            String key = next.getKey();
            Double value = next.getValue();
            sortMap.put(value,key);
        }

        List<String> resList = new ArrayList<>(number);
        for (int i = 0; i < number; i++) {
            Map.Entry<Double, String> entry = sortMap.pollLastEntry();
            resList.add(entry.getValue());
        }

        //设置session缓存
        application.setAttribute("CouldChooseList",resList);
        Object begin = application.getAttribute("beginList");
        if(begin == null){
            List<Teacher> list = new ArrayList<>();
            list.add(teacher);
            application.setAttribute("beginList",list);
        }else{
            ((List<Teacher>)begin).add(teacher);
            application.setAttribute("beginList",begin);
        }
    }

    @Transactional
    public boolean chooseTeacher(ServletContext application, int designId, int teacherId,Student student) {
        List<String> couldChooseList = (List<String>) application.getAttribute("CouldChooseList");
        List<Teacher> chooseListOfTeacher = (List<Teacher>)application.getAttribute("beginList");

        boolean b = false;
        Optional<Teacher> t1 = teacherRepository.findById(teacherId);
        for (Teacher teacher : chooseListOfTeacher) {
            if (teacher.getId() == t1.get().getId()) {
                b = true;
                break;
            }
        }
        if(!b){
            return false;
        }

        if(couldChooseList.contains(student.getSchoolNumber())) {
            chooseListRepository.insertRow(student.getId(),teacherId,designId);
            return true;
        }else{
            return false;
        }

    }
}

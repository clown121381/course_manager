package com.web.framework.course_manager.resposity;

import com.web.framework.course_manager.entity.ChooseList;
import com.web.framework.course_manager.entity.Student;
import com.web.framework.course_manager.entity.Teacher;
import com.web.framework.course_manager.util.StudentParam;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChooseListRepository extends CrudRepository<ChooseList,Integer> {
    @Modifying
    @Query(value = "insert into choose_list(student_id,teacher_id,design_id) values(?1,?2,?3)",nativeQuery = true)
    void insertRow(int studentId,int teacherId,int desginId);

    @Query(value = "select student.id, name,school_number from student join choose_list on choose_list.student_id = student.id where choose_list.teacher_id = ?1",nativeQuery = true)
    List<Object[]> findAllByTeacherId(int teacherId);
}

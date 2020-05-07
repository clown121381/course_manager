package com.web.framework.course_manager.resposity;

import com.web.framework.course_manager.entity.Course;
import com.web.framework.course_manager.entity.S_C_ManyToMany;
import com.web.framework.course_manager.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface S_C_ManyToManyRepository extends CrudRepository<S_C_ManyToMany,Integer> {

    S_C_ManyToMany findS_C_ManyToManyByCourseAndStudent(Course course,Student student);

    List<S_C_ManyToMany> findS_C_ManyToManyByCourse(Course course);

    @Modifying
    @Query(value = "update s_c_many_to_many set score = ?1 where course_id = ?2 and student_id=?3",nativeQuery = true)
    int updateSC(double score,int course_id,int student_id);

    @Modifying
    @Query(value = "delete from s_c_many_to_many where course_id = ?1 and student_id=?2",nativeQuery = true)
    int deleteSc(int course_id,int student_id);

    @Modifying
    @Query(value = "insert into s_c_many_to_many(score,course_id,student_id) values(?1,?2,?3)",nativeQuery = true)
    void insertSc(double score,int courseId,int studentId);
}

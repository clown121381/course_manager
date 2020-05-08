package com.web.framework.course_manager.resposity;

import com.web.framework.course_manager.entity.Teacher;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher,Integer> {
    Teacher findTeacherBySchoolNumber(String schoolNumber);

    int deleteTeacherBySchoolNumber(String schoolNumber);

    @Modifying
    @Query("update Teacher set name = ?1 where schoolNumber = ?2")
    int updateTeacherBySchoolNumber(String name, String schoolNumber);

    @Modifying
    @Query(value = "update teacher set password = ?1 where school_number = ?2",nativeQuery = true)
    int updateTeacherPassword(String password,String schoolNumber);
}

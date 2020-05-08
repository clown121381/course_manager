package com.web.framework.course_manager.resposity;

import com.web.framework.course_manager.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends CrudRepository<Student,Integer> {

    Student findStudentBySchoolNumber(String schoolNumber);

    @Modifying
    @Query("update Student set name=?1 where schoolNumber=?2")
    int updateStudentBySchoolNumber(String name,String schoolNumber);

    @Modifying
    int deleteStudentBySchoolNumber(String schoolNumber);

    @Modifying
    @Query(value = "update student set password = ?1 where school_number = ?2",nativeQuery = true)
    int updateStudentPassword(String password,String schoolNumber);
}

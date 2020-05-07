package com.web.framework.course_manager.resposity;

import com.web.framework.course_manager.entity.ChooseList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ChooseListRepository extends CrudRepository<ChooseList,Integer> {
    @Modifying
    @Query(value = "insert into choose_list(student_id,teacher_id,design_id) values(?1,?2,?3)",nativeQuery = true)
    void insertRow(int studentId,int teacherId,int desginId);
}

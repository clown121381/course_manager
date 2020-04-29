package com.web.framework.course_manager.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,length = 50)
    private String name;
    //权重
    private double weight;
    //课程编号
    private String courseId;
    //总学分
    private String totalScore;

    @ManyToOne
    private Teacher teacher;

    @OneToMany(mappedBy = "student")
    private List<S_C_ManyToMany> students;

    private boolean isDel;
}

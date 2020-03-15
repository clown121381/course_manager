package com.web.framework.course_manager.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,length = 50)
    private String name;
    //权重
    private double weight;

    @ManyToOne
    private Teacher teacher;

    @OneToMany(mappedBy = "student")
    private List<S_C_ManyToMany> students;

    private boolean isDel;
}

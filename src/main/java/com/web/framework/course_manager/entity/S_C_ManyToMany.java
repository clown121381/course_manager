package com.web.framework.course_manager.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class S_C_ManyToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double score;
    @ManyToOne
    private Course course;
    @ManyToOne
    private Student student;
}

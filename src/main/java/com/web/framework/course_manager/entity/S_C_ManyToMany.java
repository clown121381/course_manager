package com.web.framework.course_manager.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class S_C_ManyToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double score;
    @ManyToOne(cascade={CascadeType.ALL})
    private Course course;
    @ManyToOne(cascade={CascadeType.ALL})
    private Student student;
}

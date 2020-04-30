package com.web.framework.course_manager.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,length = 50)
    private String name;
    private String password;
    private String schoolNumber;

    @OneToMany(mappedBy = "teacher")
    @JsonIgnoreProperties(value = "teacher")
    private List<Course> courses;

    @Override
    public String toString() {
        courses.forEach(c -> {
            c.setTeacher(null);
        });
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", schoolNumber='" + schoolNumber + '\'' +
                ", courses=" + courses +
                '}';
    }
}

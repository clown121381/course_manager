package com.web.framework.course_manager.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class StudentParam {
    private String name;
    private String schoolNumber;
    private int score;
}

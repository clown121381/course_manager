package com.web.framework.course_manager.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class StudentParam {
    private String name;
    private String schoolNumber;
    private double score;
}

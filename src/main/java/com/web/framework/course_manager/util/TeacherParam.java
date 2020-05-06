package com.web.framework.course_manager.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TeacherParam {
    private int id;
    private String name;
    private String schoolNumber;
}

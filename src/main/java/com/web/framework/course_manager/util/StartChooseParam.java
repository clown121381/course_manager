package com.web.framework.course_manager.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StartChooseParam {
    private int[] courses;
    private int number;
}

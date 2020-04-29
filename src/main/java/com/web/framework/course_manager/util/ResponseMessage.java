package com.web.framework.course_manager.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage {
    private int code;
    private String message;
    private Object data;
    private boolean requestflag;
}

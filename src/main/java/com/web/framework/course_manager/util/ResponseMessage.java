package com.web.framework.course_manager.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ResponseMessage {
    private int code;
    private String message;
    private Object data;
    private boolean requestflag;
}

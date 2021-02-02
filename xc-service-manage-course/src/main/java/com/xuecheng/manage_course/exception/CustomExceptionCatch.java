package com.xuecheng.manage_course.exception;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/5/31
*/

import com.xuecheng.framework.exception.ExceptionCatch;
import com.xuecheng.framework.model.response.CommonCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice//控制器增强
public class CustomExceptionCatch extends ExceptionCatch {
    static {
        builder.put(AccessDeniedException.class, CommonCode.UNAUTHORISE);
    }
}

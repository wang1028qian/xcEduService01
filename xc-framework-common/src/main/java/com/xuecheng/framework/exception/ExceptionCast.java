package com.xuecheng.framework.exception;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/4/25
*/

import com.xuecheng.framework.model.response.ResultCode;

public class ExceptionCast {
    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}

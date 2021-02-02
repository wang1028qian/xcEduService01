package com.xuecheng.manage_course.dao;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/4/30
*/

import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeachplanMapper {
    public TeachplanNode selectList(String courseId);
}

package com.xuecheng.manage_course.dao;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/5/1
*/

import com.xuecheng.framework.domain.course.ext.CategoryNode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
     CategoryNode selectList();
}

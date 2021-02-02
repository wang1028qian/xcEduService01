package com.xuecheng.manage_course.dao;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/4/30
*/

import com.xuecheng.framework.domain.course.TeachplanMedia;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeachplanMediaRepository extends JpaRepository<TeachplanMedia,String>{
    List<TeachplanMedia> findByCourseId(String courseId);
}

package com.xuecheng.manage_course.dao;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/5/26
*/

import com.xuecheng.framework.domain.course.TeachplanMediaPub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeachplanMediaPubRepository extends JpaRepository<TeachplanMediaPub,String>{
    //根据课程id删除记录
    long deleteByCourseId(String courseId);
}

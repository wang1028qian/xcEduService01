package com.xuecheng.learning.dao;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/6/3
*/

import com.xuecheng.framework.domain.learning.XcLearningCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XcLearningCourseRepository extends JpaRepository<XcLearningCourse,String> {
    //根据课程id和用户id查询
    XcLearningCourse findByUserIdAndCourseId(String userId,String coutseId);
}

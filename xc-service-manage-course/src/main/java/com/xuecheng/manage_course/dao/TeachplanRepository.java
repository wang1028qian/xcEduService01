package com.xuecheng.manage_course.dao;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/4/30
*/

import com.xuecheng.framework.domain.course.Teachplan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeachplanRepository extends JpaRepository<Teachplan,String> {
    //定义方法根据课程id和父节点id查询出节点列表，可以使用此方法实现查询根节点
    List<Teachplan> findByCourseidAndParentid(String courseId,String paretId);
}

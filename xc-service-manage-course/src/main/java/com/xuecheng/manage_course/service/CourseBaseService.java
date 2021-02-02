package com.xuecheng.manage_course.service;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/5/1
*/

import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.response.AddCourseResult;
import com.xuecheng.framework.domain.course.response.CourseCode;
import com.xuecheng.framework.exception.ExceptionCast;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_course.dao.CourseBaseRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CourseBaseService {
    @Autowired
    CourseBaseRepository courseBaseRepository;

    @Transactional
    public AddCourseResult addCourseBase(CourseBase courseBase){
        if (courseBase == null ||
                StringUtils.isEmpty(courseBase.getName())||
                StringUtils.isEmpty(courseBase.getSt())||
                StringUtils.isEmpty(courseBase.getGrade())||
                StringUtils.isEmpty(courseBase.getStudymodel())){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        courseBase.setStatus("202001");
       courseBaseRepository.save(courseBase);

        return new AddCourseResult(CommonCode.SUCCESS,courseBase.getId());
    }
    //根据id查询课程基本信息
    public CourseBase getCoursebaseId(String courseid){
        Optional<CourseBase> optional = courseBaseRepository.findById(courseid);
        if (optional.isPresent()){
            return optional.get();
        }
        ExceptionCast.cast(CourseCode.COURSE_DENIED_FIND);
        return null;
    }

    @Transactional
    public ResponseResult updateCoursebase(String id,CourseBase courseBase){
        CourseBase one = this.getCoursebaseId(id);
        if (one ==null){
            ExceptionCast.cast(CommonCode.SELECT_NULL);
        }
        //修改课程信息
        one.setName(courseBase.getName());
        one.setMt(courseBase.getMt());
        one.setSt(courseBase.getSt());
        one.setGrade(courseBase.getGrade());
        one.setStudymodel(courseBase.getStudymodel());
        one.setUsers(courseBase.getUsers());
        one.setDescription(courseBase.getDescription());
        CourseBase save = courseBaseRepository.save(one);
        return new ResponseResult(CommonCode.SUCCESS);
    }
}

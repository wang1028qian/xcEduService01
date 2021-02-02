package com.xuecheng.learning.service;

import com.xuecheng.framework.domain.course.TeachplanMediaPub;
import com.xuecheng.framework.domain.learning.XcLearningCourse;
import com.xuecheng.framework.domain.learning.respones.GetMediaResult;
import com.xuecheng.framework.domain.learning.respones.LearningCode;
import com.xuecheng.framework.domain.task.XcTask;
import com.xuecheng.framework.domain.task.XcTaskHis;
import com.xuecheng.framework.exception.ExceptionCast;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.learning.client.CourseSearchClient;
import com.xuecheng.learning.dao.XcLearningCourseRepository;
import com.xuecheng.learning.dao.XcTaskHisRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service
public class LearningService {

    @Autowired
    CourseSearchClient courseSearchClient;
    @Autowired
    XcLearningCourseRepository xcLearningCourseRepository;
    @Autowired
    XcTaskHisRepository xcTaskHisRepository;

    //获取课程学习地址（视频播放地址）
    public GetMediaResult getmedia(String courseId, String teachplanId) {
        //校验学生的学生权限...

        //远程调用搜索服务查询课程计划所对应的课程媒资信息
        TeachplanMediaPub teachplanMediaPub = courseSearchClient.getmedia(teachplanId);
        if(teachplanMediaPub == null || StringUtils.isEmpty(teachplanMediaPub.getMediaUrl())){
            //获取学习地址错误
            ExceptionCast.cast(LearningCode.LEARNING_GETMEDIA_ERROR);
        }
        return new GetMediaResult(CommonCode.SUCCESS,teachplanMediaPub.getMediaUrl());
    }
    //添加选课
    @Transactional
    public ResponseResult addcourse(String userId, String courseId, String valid, Date startTime, Date endTime, XcTask xcTask){
        if(StringUtils.isEmpty(courseId)){
            ExceptionCast.cast(LearningCode.LEARNING_GETMEDIA_ERROR);
        }
        if (StringUtils.isEmpty(userId)){
            ExceptionCast.cast(LearningCode.CHOOSECOURSE_USERISNULl);
        }
        if (xcTask == null || StringUtils.isEmpty(xcTask.getId())){
            ExceptionCast.cast(LearningCode.CHOOSECOURSE_TASKISNULL);
        }
        XcLearningCourse xcLeaningCourse = xcLearningCourseRepository.findByUserIdAndCourseId(userId, courseId);
        if (xcLeaningCourse != null){
            //更新选课记录
            xcLeaningCourse.setStartTime(startTime);
            xcLeaningCourse.setEndTime(endTime);
            xcLeaningCourse.setStatus("501001");
            xcLearningCourseRepository.save(xcLeaningCourse);
        }else {
            //添加新得选课记录
            XcLearningCourse xcLearningCourse = new XcLearningCourse();
            xcLeaningCourse.setUserId(userId);
            xcLeaningCourse.setCourseId(courseId);
            xcLeaningCourse.setStartTime(startTime);
            xcLeaningCourse.setEndTime(endTime);
            xcLeaningCourse.setStatus("501001");
            xcLearningCourseRepository.save(xcLeaningCourse);
        }
        //向历史任务表插入记录
        Optional<XcTaskHis> optional = xcTaskHisRepository.findById(xcTask.getId());
        if(!optional.isPresent()){
            //添加
            XcTaskHis xcTaskHis = new XcTaskHis();
            BeanUtils.copyProperties(xcTask,xcTaskHis);
            xcTaskHisRepository.save(xcTaskHis);
        }
        return new ResponseResult(CommonCode.SUCCESS);
    }
}

















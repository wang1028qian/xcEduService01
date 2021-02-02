package com.xuecheng.manage_course.controller;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/5/1
*/

import com.xuecheng.api.course.CourseBaseControllerApi;
import com.xuecheng.api.course.CourseControllerApi;
import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_course.service.CourseBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course/coursebase")
public class CourseBaseController implements CourseBaseControllerApi{
    @Autowired
    CourseBaseService courseBaseService;

    @Override
    @PostMapping("/add")
    public ResponseResult addCouseBase(@RequestBody CourseBase courseBase) {
        return courseBaseService.addCourseBase(courseBase);
    }

    @Override
    @GetMapping("/get/{courseId}")
    public CourseBase getCourseBaseById(@PathVariable("courseId") String courseId) throws RuntimeException {
        return courseBaseService.getCoursebaseId(courseId);
    }

    @
            Override
    @PutMapping("/update/{id}")
    public ResponseResult updateCourseBase(@PathVariable("id") String id, @RequestBody CourseBase
            courseBase) {
        return courseBaseService.updateCoursebase(id,courseBase);
    }
}

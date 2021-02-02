package com.xuecheng.api.course;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/5/1
*/

import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.CourseMarket;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "课程基本信息管理",description = "课程基本信息接口，提供课程的增，删，改，查")
public interface CourseBaseControllerApi {
    @ApiOperation("添加课程基本信息")
    public ResponseResult addCouseBase(CourseBase courseBase);
    @ApiOperation("获取课程基础信息")
    public CourseBase getCourseBaseById(String courseId);
    @ApiOperation("修改课程信息")
    public ResponseResult updateCourseBase(String id,CourseBase courseBase);
}

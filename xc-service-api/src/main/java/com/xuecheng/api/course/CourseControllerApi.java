package com.xuecheng.api.course;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/4/30
*/

import com.sun.javafx.logging.PulseLogger;
import com.xuecheng.framework.domain.course.*;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.ext.CourseView;
import com.xuecheng.framework.domain.course.ext.TeachplanExt;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.domain.course.response.CoursePublishResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;

@Api(value = "课程管理接口",description = "课程管理接口，提供课程的增，删，改，查")
public interface CourseControllerApi {
    @ApiOperation("课程计划查询")
    public TeachplanNode findTeachplanList(String courseId);

    @ApiOperation("添加课程计划")
    public ResponseResult addTeachplan(Teachplan teachplan);

    @ApiOperation("查询课程营销")
    public CourseMarket getCourseMarketById(String courseId);

    @ApiOperation("更新课程营销")
    public ResponseResult updateCourseMarket(String courseId, CourseMarket courseMarket);

    @ApiOperation("添加课程图片")
    public ResponseResult addCoursePic(String courseId, String pic);

    @ApiOperation("查询课程图片")
    public CoursePic findCoursePic(String courseId);

    @ApiOperation("删除课程图片")
    public ResponseResult deleteCoursePic(String courseId);

    @ApiOperation("课程视图查询")
    public CourseView courseview(String id);

    @ApiOperation("课程预览")
    public CoursePublishResult preview(String id);
    @ApiOperation("发布课程")
    public CoursePublishResult publish(@PathVariable String id);
    @ApiOperation("保存课程计划与媒资文件关联")
    public ResponseResult savemedia(TeachplanMedia teachplanMedia);
    @ApiOperation("课程查询")
    public QueryResponseResult<CourseInfo> findCourseList(int page,
                                                          int size,
                                                          CourseListRequest courseListRequest);
}
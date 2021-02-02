package com.xuecheng.manage_course.controller;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/4/30
*/

import com.xuecheng.api.course.CourseControllerApi;
import com.xuecheng.framework.domain.course.CourseMarket;
import com.xuecheng.framework.domain.course.CoursePic;
import com.xuecheng.framework.domain.course.Teachplan;
import com.xuecheng.framework.domain.course.TeachplanMedia;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.ext.CourseView;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.domain.course.response.CoursePublishResult;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.utils.XcOauth2Util;
import com.xuecheng.framework.web.BaseController;
import com.xuecheng.manage_course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController extends BaseController implements CourseControllerApi {
    @Autowired
    CourseService courseServic;

    //当用户拥有course_teachplan_list权限时候方可访问此方法
    //@PreAuthorize("hasAuthority('course_teachplan_list')")
    @Override
    @GetMapping("/teachplan/list/{courseId}")
    public TeachplanNode findTeachplanList(@PathVariable("courseId") String courseId){
        return courseServic.findTeachplanList(courseId);
    }
    @Override
    @PostMapping("/teachplan/add")
    public ResponseResult addTeachplan(@RequestBody Teachplan teachplan){
        return courseServic.addTeachplan(teachplan);
    }

    @Override
    @GetMapping("/coursemarket/get/{courseId}")
    public CourseMarket getCourseMarketById(@PathVariable("courseId") String courseId) {
        return courseServic.getCourseMarketById(courseId);
    }

    @Override
    @PostMapping("/coursemaket/update/{courseId}")
    public ResponseResult updateCourseMarket(@PathVariable("courseId") String courseId,
                                             @RequestBody CourseMarket courseMarket) {
        CourseMarket courseMarket1 = courseServic.updateCourseMarket(courseId, courseMarket);
        if (courseMarket1 !=null){
            return new ResponseResult(CommonCode.SUCCESS);
        }else {
            return new ResponseResult(CommonCode.FAIL);
        }
    }

    @Override
    @PostMapping("/coursepic/add")
    public ResponseResult addCoursePic(@RequestParam("courseId") String courseId,@RequestParam("pic") String pic) {
        return courseServic.addCoursePic(courseId,pic);
    }

    @Override
    @GetMapping("/coursepic/list/{courseId}")
    public CoursePic findCoursePic(@PathVariable("courseId") String courseId) {
        return courseServic.findCoursePic(courseId);
    }

    @Override
    @DeleteMapping("/coursepic/delete")
    public ResponseResult deleteCoursePic(@RequestParam("courseId") String courseId) {
        return courseServic.deleteCoursePic(courseId);
    }

    @Override
    @GetMapping("/courseview/{id}")
    public CourseView courseview(@PathVariable("id") String id) {
        return courseServic.getCourseView(id);
    }

    @Override
    @PostMapping("/preview/{id}")
    public CoursePublishResult preview(@PathVariable("id") String id) {
        return courseServic.preview(id);

    }

    @Override
    @PostMapping("/publish/{id}")
    public CoursePublishResult publish(@PathVariable("id") String id) {
        return courseServic.publish(id);
    }

    @Override
    @PostMapping("/savemedia")
    public ResponseResult savemedia(@RequestBody TeachplanMedia teachplanMedia) {
        return courseServic.savemedia(teachplanMedia);
    }

    @Override
    @GetMapping("/coursebase/list/{page}/{size}")
    public QueryResponseResult<CourseInfo> findCourseList(@PathVariable("page") int page,
                                                          @PathVariable("size") int size, CourseListRequest courseListRequest) {
        //获取当面用户信息
        XcOauth2Util xcOauth2Util = new XcOauth2Util();
        XcOauth2Util.UserJwt userJwt = xcOauth2Util.getUserJwtFromHeader(request);
        //当前用户所属单位的id
        String companyId = userJwt.getCompanyId();
        QueryResponseResult<CourseInfo> queryResponseResult = courseServic.findCourseList(companyId, page, size, courseListRequest);

        return queryResponseResult;
    }

}



























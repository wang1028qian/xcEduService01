package com.xuecheng.framework.domain.course.ext;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/5/12
*/

import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.CourseMarket;
import com.xuecheng.framework.domain.course.CoursePic;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class CourseView implements Serializable{
    private CourseBase courseBase;
    private CoursePic coursePic;
    private CourseMarket courseMarket;
    private TeachplanNode teachplanNode;

}

package com.xuecheng.learning.mq;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/6/3
*/

import com.alibaba.fastjson.JSON;
import com.xuecheng.framework.domain.course.response.AddCourseResult;
import com.xuecheng.framework.domain.task.XcTask;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.learning.config.RabbitMQConfig;
import com.xuecheng.learning.service.LearningService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Component
public class ChooseCourseTask {
    @Autowired
    LearningService learningService;
    @Autowired
    RabbitTemplate rabbitTemplate;

    //接收发送任务消息
    @RabbitListener(queues = RabbitMQConfig.XC_LEARNING_ADDCHOOSECOURSE)
    public void receiveChoosecourseTask(XcTask xcTask){
        //取出消息的内容
        try {
            String requestBody = xcTask.getRequestBody();
            Map map = JSON.parseObject(requestBody, Map.class);
            String userId = (String) map.get("userId");
            String courseId = (String) map.get("courseId");
            String valid = (String) map.get("valid");
            Date startTime = null;
            Date endTime = null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            if (map.get("starTime") != null){
                startTime = dateFormat.parse((String)map.get("endTime"));
            }
            if(map.get("endTime")!=null){
                endTime = dateFormat.parse((String)map.get("startTime"));
            }
            //添加选课
            ResponseResult addcourse = learningService.addcourse(userId, courseId,valid,startTime,endTime,xcTask);
            //选课成功发送相应消息
            if (addcourse.isSuccess()){
                //发送相应消息
                rabbitTemplate.convertAndSend(RabbitMQConfig.EX_LEARNING_ADDCHOOSECOURSE,RabbitMQConfig.XC_LEARNING_FINISHADDCHOOSECOURSE_KEY,xcTask);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

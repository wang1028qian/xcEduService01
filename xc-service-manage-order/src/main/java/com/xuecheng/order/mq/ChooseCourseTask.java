package com.xuecheng.order.mq;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/6/3
*/

import com.xuecheng.framework.domain.task.XcTask;
import com.xuecheng.order.config.RabbitMQConfig;
import com.xuecheng.order.service.TaskService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class ChooseCourseTask {
    @Autowired
    TaskService taskService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ChooseCourseTask.class);
   @RabbitListener(queues = RabbitMQConfig.XC_LEARNING_FINISHADDCHOOSECOURSE)
   public void receiveFinishChoosecourseTask(XcTask xcTask){
       if (xcTask != null && StringUtils.isNotEmpty(xcTask.getId())){
           taskService.finlishTask(xcTask.getId());
       }
   }

    //向course发送任务
    @Scheduled(cron = "0/3 * * * * *")
    public void sendChoosecourseTask(){
        //得到1分钟之间的时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.set(GregorianCalendar.MINUTE,-1);
        Date time = calendar.getTime();
        List<XcTask> xcTaskList = taskService.findXcTaskList(time, 100);
        //调用service发布消息，将添加选课的发布任务发送mq
        for (XcTask xcTask:xcTaskList){
            if (taskService.getTask(xcTask.getId(),xcTask.getVersion()) > 0){
                String ex = xcTask.getMqExchange();//要发送的交换机
                String routingKey = xcTask.getMqRoutingkey();//发送消息要带routingKey
                taskService.publish(xcTask,ex,routingKey);
            }
        }
    }
}

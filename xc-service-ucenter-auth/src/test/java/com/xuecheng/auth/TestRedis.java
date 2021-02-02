package com.xuecheng.auth;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/5/29
*/

import com.alibaba.fastjson.JSON;
import org.hibernate.boot.jaxb.SourceType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRedis {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
    public void testRedis(){
        //定义key
        String key = "83a7fb1c-50b6-4369-943f-255d71edf480";
        //定义value
        Map<String,String> value = new HashMap<>();
        value.put("jwt","eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJjb21wYW55SWQiOm51bGwsInVzZXJwaWMiOm51bGwsInVzZXJfbmFtZSI6Iml0Y2FzdCIsInNjb3BlIjpbImFwcCJdLCJuYW1lIjpudWxsLCJ1dHlwZSI6bnVsbCwiaWQiOm51bGwsImV4cCI6MTU1OTE2NTgxNiwianRpIjoiODNhN2ZiMWMtNTBiNi00MzY5LTk0M2YtMjU1ZDcxZWRmNDgwIiwiY2xpZW50X2lkIjoiWGNXZWJBcHAifQ.GXE7xEKj4P4tPm9oMv6Ttn5OMIT3AyXEgyYsU99nQWb_KidlMlvquEqhETcg8p9Y9DJ-TlzMuSWBNk1MFX0QtUs3WR3R3HKfkMD4HGOfFQJ1Vy6kYhJOSVLL9pGm1Nnx1t0zBzfQ7mvs5Mnw6WZ33Pd9MvvyYhhxoNhkhkmQNiVb3vaAcMZruDwzRivC0-wk6vfY55sATw1tsm-ZHbj9MiHqrFVxUBzkK9LF_ImZD1ccfcm6nm2jaW4jZmxihOXyHls0LdeHwl2PlvFEwtRtBsTPn7UpByEyFRuz0lxUxxbxBVScG6adBE4XZvoaq76N11oQp4nwRMPv99UkOBzTjw");
        value.put("refresh_token","eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJjb21wYW55SWQiOm51bGwsInVzZXJwaWMiOm51bGwsInVzZXJfbmFtZSI6Iml0Y2FzdCIsInNjb3BlIjpbImFwcCJdLCJhdGkiOiI4M2E3ZmIxYy01MGI2LTQzNjktOTQzZi0yNTVkNzFlZGY0ODAiLCJuYW1lIjpudWxsLCJ1dHlwZSI6bnVsbCwiaWQiOm51bGwsImV4cCI6MTU1OTE2NTgxNiwianRpIjoiMmI1ZTU2MzgtMThhMS00YWU4LTgzOTAtYWMyYzhkODlhNWQ0IiwiY2xpZW50X2lkIjoiWGNXZWJBcHAifQ.LHo9mQaG9c8KMgBwqDTCZ0QZQd_sV86kcd9C6uLqnzgKvURNUBj8L9Gj7Vci4fgqvVo2DNgmwS_cWw4cAO1vW20hUQSVdVfOnShOMRvT7S6N_zD1S_FVoI_HXI_6i6SWwyBsTezoJFGv0o1taT-GhnLQUQXtMOozM8MnEVOQLp9ud4fWJ9pTFyo6aCUTubbYvFfPVRqZ0l5wS4sjq3QTMjD8AbqAEPYcS3EL5qYxl62a49z1ymtbiZHEyKSCjDQs1VJbU0-T702imumF7qDOfSJ9HMNkC9_sTsChkykU0RKEADXLA220FrYAc4uQVGTncRR-vyGmy1cKR9N_Et8hNQ");

        String jsonString = JSON.toJSONString(value);
        //校验key如果不存在返回-2
        Long expire = stringRedisTemplate.getExpire(key, TimeUnit.SECONDS);
        System.out.println(expire);
        //存储数据
        stringRedisTemplate.boundValueOps(key).set(jsonString,30,TimeUnit.SECONDS);
        //获取数据
        String string = stringRedisTemplate.opsForValue().get(key);
        System.out.println(string);

    }
}

package com.xuecheng.test.freemarker.model;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/4/26
*/

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class Student {
    private String name;//姓名
    private int age;//年龄
    private Date birthday;//生日
    private Float mondy;//钱包
    private List<Student> friends;//朋友列表
    private Student bestFriend;//最好的朋友
}

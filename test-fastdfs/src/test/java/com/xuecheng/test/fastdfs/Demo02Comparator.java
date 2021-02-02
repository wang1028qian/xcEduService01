package com.xuecheng.test.fastdfs;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/6/20
*/

import java.util.Comparator;

public class Demo02Comparator {
    public static Comparator<String> getComparator(){
/*        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        };*/
/*        return (String o1,String o2)->{
            return o2.length()-o1.length();
        };*/
        return (o1,o2)->o2.length()-o1.length();
    }
    public static void startThread(Runnable run){
        //开启多线程
        new Thread(run).start();
    }

    public static void main(String[] args) {
        startThread(()-> System.out.println(Thread.currentThread().getName()+"线程启动啦"));
    }
}

package com.xuecheng.manage_cms.dao;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/4/27
*/

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_cms.service.PageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.SocketTimeoutException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PageServiceTeset {
    @Autowired
    PageService pageService;
    @Test
    public void testGetPageHtmal(){
        String pageHtml = pageService.getPageHtml("5a795ac7dd573c04508f3a56");
        System.out.println(pageHtml);
    }
    @Test
    public void testGetById(){
        CmsPage byId = pageService.getById("5a94d79cb00ffc3ab4bfa4f6");
        System.out.println(byId.toString());
    }
}

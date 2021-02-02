package com.xuecheng.manage_course.client;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.domain.cms.response.CmsPostPageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator.
 */
@FeignClient(value = "XC-SERVICE-MANAGE-CMS") //指定远程调用的服务名
public interface CmsPageClient {
    //根据页面id查询页面信息，远程调用cms请求数据
    @RequestMapping(value = "/cms/page/get/{id}",method = RequestMethod.GET)
/*    @GetMapping("/cms/page/get/{id}")*/
    public CmsPage findCmsPageById(@PathVariable("id") String id);

    //添加页面，用于课程预览
    @RequestMapping(value = "/cms/page/save",method = RequestMethod.POST)
    public CmsPageResult saveCmsPage(@RequestBody CmsPage cmsPage);
    //一键发布课程
    @RequestMapping(value = "/cms/page/postPageQuick",method = RequestMethod.POST)
    public CmsPostPageResult postPageQuick(@RequestBody CmsPage cmsPage);

}

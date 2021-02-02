package com.xuecheng.framework.domain.cms.request;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/4/19
*/

import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

@Data
public class QueryPageRequest {
    //接收页面查询的查询条件
    //站点ID
    private  String  siteId;
    //页面ID
    private String pageId;
    //页面名称
    private String pageName;
    //别名
    private String pageAliase;
    //模板id
    private String templateId;
}

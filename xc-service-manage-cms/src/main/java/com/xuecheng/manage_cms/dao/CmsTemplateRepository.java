package com.xuecheng.manage_cms.dao;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/4/26
*/

import com.xuecheng.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsTemplateRepository extends MongoRepository<CmsTemplate,String> {
}

package com.xuecheng.manage_cms.dao;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/4/26
*/

import com.mongodb.Mongo;
import com.xuecheng.framework.domain.cms.CmsConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsConfigRepository extends MongoRepository<CmsConfig, String> {
}

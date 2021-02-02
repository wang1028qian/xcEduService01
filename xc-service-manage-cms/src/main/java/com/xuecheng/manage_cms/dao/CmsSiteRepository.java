package com.xuecheng.manage_cms.dao;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/5/14
*/

import com.xuecheng.framework.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsSiteRepository extends MongoRepository<CmsSite,String>{
}

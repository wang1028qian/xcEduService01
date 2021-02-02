package com.xuecheng.manage_cms.dao;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/5/1
*/

import com.xuecheng.framework.domain.system.SysDictionary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.jmx.export.annotation.ManagedResource;

public interface SysDicthinaryRepository extends MongoRepository<SysDictionary,String>{
    //根据dType查询
    SysDictionary findByDType(String bType);
}

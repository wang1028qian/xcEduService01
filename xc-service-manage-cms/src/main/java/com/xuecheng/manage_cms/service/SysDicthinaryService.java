package com.xuecheng.manage_cms.service;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/5/1
*/

import com.xuecheng.framework.domain.system.SysDictionary;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.SysDicthinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysDicthinaryService {
    @Autowired
    SysDicthinaryRepository sysDicthinaryRepository;

    public SysDictionary getByType(String type){
        SysDictionary sysDictionary = sysDicthinaryRepository.findByDType(type);
//        QueryResult queryResult = new QueryResult();
//        return new QueryResponseResult(CommonCode.SUCCESS,sysDictionary);
        return sysDictionary;
    }
}

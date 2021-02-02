package com.xuecheng.manage_cms.controller;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/5/1
*/

import com.xuecheng.api.sysDicthinary.SysDicthinaryControllerApi;
import com.xuecheng.framework.domain.system.SysDictionary;
import com.xuecheng.manage_cms.service.SysDicthinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/dictionary")
public class SysDictionaryController implements SysDicthinaryControllerApi {
    @Autowired
    SysDicthinaryService sysDicthinaryService;


    @Override
    @GetMapping("/get/{type}")
    public SysDictionary getByType(@PathVariable("type") String type) {
        return sysDicthinaryService.getByType(type);
    }
}

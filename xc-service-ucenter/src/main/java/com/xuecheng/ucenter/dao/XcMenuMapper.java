package com.xuecheng.ucenter.dao;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/5/31
*/

import com.xuecheng.framework.domain.ucenter.XcMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface XcMenuMapper {
    //根据用户id查询用的权限
    public List<XcMenu> selectPermissionByUserId(String userId);
}

package com.xuecheng.ucenter.dao;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/5/30
*/

import com.xuecheng.framework.domain.ucenter.XcUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XcUserRepository extends JpaRepository<XcUser,String> {
    //根据帐号查询用户信息
    XcUser findByUsername(String username);
}

package com.xuecheng.api.ucenter;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/5/30
*/

import com.xuecheng.framework.domain.ucenter.ext.XcUserExt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "用户中心",description = "用户中心管理")
public interface UcenterControllerApi {
    @ApiOperation("根据用户帐号查询用户信息")
    public XcUserExt getUserext(String username);
}

package com.xuecheng.govern.gateway.filter;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/5/31
*/

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.govern.gateway.service.AuthService;
import jdk.nashorn.internal.objects.NativeNumber;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.channels.AcceptPendingException;

/**
 * 身份校验
 *
 */
@Component
public class LoginFilter extends ZuulFilter{
    @Autowired
    AuthService authService;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        //得到request
        HttpServletRequest request = requestContext.getRequest();
        //得到response
        HttpServletResponse response = requestContext.getResponse();
        //取出cookie中的身份令牌
        String tokenFromCookie = authService.getTokenFromCookie(request);
        if (StringUtils.isEmpty(tokenFromCookie)){
            //拒绝访问
            access_denied();
            return null;
        }
        //从hearder中取出jwt
        String jwtFromHeader = authService.getJwtFromHeader(request);
        if (StringUtils.isEmpty(jwtFromHeader)){
            access_denied();
            return null;
        }
        //从redis取出jwt的过期时间
        long expire = authService.getExpire(tokenFromCookie);
        if (expire<=0){
            access_denied();
            return null;
        }
        return null;
    }

    //拒绝访问
    private void access_denied(){
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletResponse response = requestContext.getResponse();
        //拒绝访问
        requestContext.setSendZuulResponse(false);
        //设置响应代码
        requestContext.setResponseStatusCode(200);
        //构建相应的消息
        ResponseResult responseResult = new ResponseResult(CommonCode.UNAUTHENTICATED);
        //转成json
        String jsonString = JSON.toJSONString(responseResult);
        requestContext.setResponseBody(jsonString);
        //转成json，设置contentType
        response.setContentType("application/json;charset=utf-8");
    }
}

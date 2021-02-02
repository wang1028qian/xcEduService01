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
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.cert.CRLReason;
//@Component
public class LoginFilterTest extends ZuulFilter{
    /**
     * pre:请求在被路由之前执行
     * routing:在路由请求时调用
     * post：在routing和error过滤器之后调用
     * error:处理请求时发生错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "rpe";
    }
    //过滤器序号，越小越被优先执行
    @Override
    public int filterOrder() {
        return 0;
    }
    //返回turn表示执行此过滤器
    @Override
    public boolean shouldFilter() {
        return true;
    }
    //过滤器的内容
    //执行的需求:过滤所有的请求，判断头部信息是否有Authorization,如果没有则拒绝访问，否则转发到微服务
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        HttpServletResponse response = currentContext.getResponse();
        String authorization = request.getHeader("Authorization");
        if (StringUtils.isEmpty(authorization)){
            //拒绝访问
            currentContext.setSendZuulResponse(false);
            //设置响应信息
            currentContext.setResponseStatusCode(200);
            //构建相应的信息
            ResponseResult responseResult = new ResponseResult(CommonCode.UNAUTHENTICATED);
            //转成JSON
            String jsonString = JSON.toJSONString(responseResult);
            currentContext.setResponseBody(jsonString);
            //转成json，设置contentType
            response.setContentType("application/json;charset=utf-8");
            return null;

        }
        return null;
    }
}

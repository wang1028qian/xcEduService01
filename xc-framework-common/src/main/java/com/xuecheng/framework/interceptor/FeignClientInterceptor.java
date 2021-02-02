package com.xuecheng.framework.interceptor;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/6/2
*/

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.plugin2.message.HeartbeatMessage;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 拦截器
 *
 */
public class FeignClientInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null){
            HttpServletRequest request = requestAttributes.getRequest();
            Enumeration<String> headerNames = request.getHeaderNames();
            if (headerNames != null){
                while (headerNames.hasMoreElements()) {
                    String headerName = headerNames.nextElement();
                    String header = request.getHeader(headerName);
                    //将header向下传递
                    requestTemplate.header(headerName,header);
                }
            }
        }
    }
}

package com.example.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 14:48 2019/5/7
 */
public class TokenFilter extends ZuulFilter {

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
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if (token == null){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            context.setResponseBody("unAuthrized");
            return null;
        }
        return null;
    }
}

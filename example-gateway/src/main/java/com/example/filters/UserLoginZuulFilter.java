package com.example.filters;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

//加入到Spring容器
@Component 
public class UserLoginZuulFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// 过滤器是否需要执行
		return true;
	}

	@Override
	public Object run() {
		// 编写业务逻辑
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		String token = request.getParameter("token");
		if (StringUtils.isEmpty(token)) {
			requestContext.setSendZuulResponse(false);
			requestContext.setResponseStatusCode(401);
			return null;
		}
		return null;
	}

	@Override
	public String filterType() {
		// 设置过滤器类型  有pre,routing,post,error
		return "pre";
	}

	@Override
	public int filterOrder() {
		// 执行顺序  0最高
		return 0;
	}

}

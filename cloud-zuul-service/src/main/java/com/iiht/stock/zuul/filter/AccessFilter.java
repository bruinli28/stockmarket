package com.iiht.stock.zuul.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.client.RestTemplate;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 资源过滤器
 * 所有的资源请求在路由之前进行前置过滤
 * 如果请求头不包含Authorization参数值，直接拦截不再路由
 * 
 * @author bruin.li
 *
 */
public class AccessFilter extends ZuulFilter{
	private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);
	
	@Autowired
	private RestTemplate restTempate;
	
	/**
	 * 过滤器是否会被执行
	 * 返回true代表需要权限校验，false代表不需要用户校验即可访问
	 */
	@Override
	public boolean shouldFilter() {
        //共享RequestContext，上下文对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        System.out.println(request.getRequestURI());
        //不需要权限校验URL
//        if ("/auth/oauth/token".equalsIgnoreCase(request.getRequestURI())) {
//            return false;
//        } else if ("/apigateway/order/api/v1/order/list".equalsIgnoreCase(request.getRequestURI())) {
//            return false;
//        } else if ("/apigateway/order/api/v1/order/find".equalsIgnoreCase(request.getRequestURI())) {
//            return false;
//        }
        
        return true;
	}

	/**
	 * 过滤器的类型 pre表示请求在路由之前被过滤
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 过滤器的执行顺序
     * @return 顺序 数字越大表示优先级越低，越后执行
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public Object run() {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		
		logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
		String url = request.getRequestURL().toString();
		// 如果是登录链接，则发起请求
		// URL: http://localhost:8901/auth/oauth/token?grant_type=password&scope=webclient&username=admin&password=admin
		if("/auth/oauth/token".equals(url)){
			return null;
		}
		
		Object accessToken = request.getHeader("Authorization");
		if (accessToken == null) {
			logger.warn("Authorization token is empty.");
			requestContext.setSendZuulResponse(false);
			requestContext.setResponseStatusCode(401);
			requestContext.setResponseBody("Authorization token is empty.");
			return null;
		} else {
			try {
				// 使用Token去调用：http://localhost:8901/auth/user，如果能返回User信息，则证明token有效
				User user = restTempate.getForObject("http://localhost:8901/auth/user", User.class);
				// User user = restTempate.getForObject("http://cloud-auth-service/auth/user", User.class);
				if (user == null) {
					logger.info("The user is null...");
					requestContext.setSendZuulResponse(false);
					requestContext.setResponseStatusCode(401);
					requestContext.setResponseBody("Cannot get the user.");
				}else{
					logger.info("Login user: " + user);
				}
				// TODO 利用返回的权限信息，进行权限校验

				// TODO 如果没有权限，则不请求转发
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		logger.info("Authorization token is ok");
		return null;
	}
}

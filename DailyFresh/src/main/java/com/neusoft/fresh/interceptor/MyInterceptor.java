package com.neusoft.fresh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import com.neusoft.fresh.model.Supplier;
import com.neusoft.fresh.model.User;

/**
 * 定义拦截器
 */
public class MyInterceptor implements HandlerInterceptor {
	private static final Logger log = LoggerFactory.getLogger(MyInterceptor.class);
//	private static final String COOKIE_NAME="userid";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestURI = request.getRequestURI();
		log.info("操作url："+requestURI);
		
		HttpSession session = request.getSession();
//		Cookie[] cookies = request.getCookies();
//		if(cookies!=null&&cookies.length>0){
//			for (Cookie cookie : cookies) {
//				if(cookie.getName().equals(COOKIE_NAME)){
//					log.info("用户id："+cookie.getValue()+"，操作url："+requestURI);
//					//放行
//					return true;
//				}
//			}
//		}
		
		//如果url中包含admin,则说明是跳转到后台
		if(requestURI.contains("/admin")){
			Supplier admin=(Supplier) session.getAttribute("admin");
			if(admin!=null){
				if(!StringUtils.isEmpty(admin.getUsername())){
					return true;
				}
			}
			//跳转到后台登录页面
			response.sendRedirect("/admin/login.html");
		}else{
			User user=(User) session.getAttribute("user");
			if(user!=null){
				if(!StringUtils.isEmpty(user.getUsername())){
					return true;
				}
			}
			//跳转到前台登录页面
			response.sendRedirect("/portal/login.html");
		}
		return false;
	}
}

package com.yg.festival.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception 
	{
//		MemberBean mBean = 
//				(MemberBean)request.getSession().getAttribute(Constants.MEMBER_LOGIN_BEAN);
//		if( mBean != null ) return true;
//		
//		response.sendRedirect("/member/loginFormAjax.do");
		
		return false;
	}
	
}

package com.test.web.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.test.web.member.bean.MemberBean;

public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		MemberBean mBean = (MemberBean) request.getSession().getAttribute("memberBean");
		if (mBean != null) {
			return true;
		}
		response.sendRedirect("/member/loginForm.do");
		return false; // 화면에 아무런 변화가 없다
	}
} // end of class

package com.test.web.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.web.member.bean.MemberBean;
import com.test.web.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService; 
	
	// 로그인 후, 메인화면
	@RequestMapping("/index")
	public String index() {
		return "/index";
	}
	// 로그인 화면 보기
	@RequestMapping("/member/loginForm")
	public String loginForm() {
		return "/member/loginForm";
	}
	// 로그인 처리
	@RequestMapping("/member/loginProcAjax")
	@ResponseBody
	public Map<String, Object> loginProcAjax(MemberBean bean, HttpServletRequest req) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");
		resMap.put("memberBean", bean);
		
		try {
			MemberBean mBean = memberService.selectMember(bean); // 지금 에러발생
			System.out.println("로그인 실패!");
			
			if (mBean != null && mBean.getMemberId().equals(bean.getMemberId()) && !"".equals(bean.getMemberId())) {
				System.out.println("로그인 성공!");
				
				resMap.put("result", "ok");
				resMap.put("memberBean", mBean);
				
				req.getSession().setAttribute("memberBean", mBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resMap;
	}
	// 회원 조회
	@RequestMapping("/member/selectMemberForm")
	public String selectMemberForm() {
		return "/member/selectMemberForm";
	}
	// 회원 조회 처리
	@RequestMapping("/member/selectMemberProcAjax")
	@ResponseBody
	public Map<String, Object> selectMemberProcAjax(MemberBean bean) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");
		resMap.put("memberBean", bean);
		
		try {
			MemberBean mBean = memberService.selectMember(bean);
			System.out.println("회원 조회 성공!");
			
			resMap.put("result", "ok");
			resMap.put("memberBean", mBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resMap;
	}
	// 회원 전체 조회
	@RequestMapping("/member/selectMemberListProcAjax")
	@ResponseBody
	public Map<String, Object> selectMemberListProcAjax(MemberBean bean) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");
		
		try {
			List<MemberBean> list = memberService.selectMemberList(bean);
			
			resMap.put("result", "ok");
			resMap.put("list", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resMap;
	}
	
	// 회원가입 화면 보기
	@RequestMapping("/member/insertMemberForm")
	public String insertMemberForm() {
		return "/member/insertMemberForm";
	}
	// 회원가입 처리
	@RequestMapping("/member/insertMemberAjax")
	@ResponseBody
	public int insertMemberAjax(MemberBean mBean) {
		return 0;
	}
	
} // end of class

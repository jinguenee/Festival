package com.test.web.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.web.member.bean.MemberBean;
import com.test.web.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;

	@RequestMapping("/member/selectMember.do")
	public String selectMember(MemberBean memberBean, Model model) throws Exception {
		memberBean = memberService.selectMember(memberBean);
		model.addAttribute("memberBean", memberBean);
		return "member/selectMember";
	}

	/** 회원 가입 화면 */
	@RequestMapping("/member/insertMemberForm.do")
	public String insertMemberForm() throws Exception {
		return "member/insertMemberForm";
	}

	/** 회원 가입 처리 */
	@RequestMapping("/member/insertMember.do")
	public String insertMember(MemberBean memberBean, Model model) throws Exception {

		int resultCnt = memberService.insertMember(memberBean);
		String result = "";
		if (resultCnt == 0) {
			result = "failure";
		} else {
			result = "success";
		}

		model.addAttribute("result", result);
		model.addAttribute("memberBean", memberBean);

		return "member/insertMemberCompleted";
	}

	/** 회원 아이디 중복 체크 */
	@RequestMapping("/member/chkMemberId.do")
	@ResponseBody
	public Map<String, String> chkMemberId(String memberId) throws Exception {

		Map<String, String> resultMap = new HashMap<String, String>();

		int resultCnt = memberService.chkMemberId(memberId);
		String result = "";
		String resultMsg = "";
		if (resultCnt == 0) {
			result = "success";
			resultMsg = "사용가능한 아이디입니다.";
		} else {
			result = "failure";
			resultMsg = "이미 사용중인 아이디입니다.";
		}

		resultMap.put("result", result);
		resultMap.put("resultMsg", resultMsg);

		return resultMap;
	}

}

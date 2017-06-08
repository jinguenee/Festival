package com.yg.festival.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yg.festival.common.Constants;
import com.yg.festival.member.bean.MemberBean;
import com.yg.festival.member.service.MemberService;
import com.yg.festival.utils.SessionUtil;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	/**
	 * 회원 로그인 폼
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/member/loginForm")
	public String loginForm() throws Exception {
		return "/member/loginForm";
	}
	
	//회원가입화면
	@RequestMapping("/join")
	public String joinForm() {
		return "/join";
	}
	//회원가입처리
	@RequestMapping("/joinProc")
	@ResponseBody
	public Map<String, Object> joinProc(MemberBean memberBean) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put(Constants.RESULT, Constants.RESULT_FAIL);
		resMap.put(Constants.RESULT_MSG, "회원가입에 실패하였습니다.");
		//DB insert
		try{
			int res = memberService.insertMember(memberBean);
			if(res>0){
				resMap.put(Constants.RESULT, Constants.RESULT_OK);
				resMap.put(Constants.RESULT_MSG, "회원가입에 성공하였습니다.");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return resMap;
	}
	//ID 중복확인
	@RequestMapping("/joinDoubleCheckProc")
	@ResponseBody
	public Map<String, Object> joinDoubleCheckProc(MemberBean memberBean) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put(Constants.RESULT, Constants.RESULT_FAIL);
		
		//DB select
		try{
			
			if(memberService.selectMember(memberBean) != null){
				resMap.put(Constants.RESULT, Constants.RESULT_OK);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return resMap;
	}
	
	// /**
	// * 내정보 보기 폼
	// *
	// * @return
	// * @throws Exception
	// */
	// @RequestMapping("member/info")
	// public String memberInfoForm(HttpServletRequest request) throws Exception
	// {
	// MemberBean memberBean = SessionUtils.getMemberBean(request);
	// switch (memberBean.getMbTypeCd()) {
	// // 슈퍼 관리자
	// case CodeConstant.MB_TYPE_CD_01:
	// return "/member/IndInfoForm";
	// //일반관리자
	// case CodeConstant.MB_TYPE_CD_02:
	// return "/member/IndInfoForm";
	// //구인자 (기업)
	// case CodeConstant.MB_TYPE_CD_03:
	// return "/member/LicenseInfoForm";
	// //구직자 (개인)
	// case CodeConstant.MB_TYPE_CD_04:
	// return "/member/IndInfoForm";
	// }
	// return "/main/index";
	// }

	/**
	 * 패스워드 재확인 폼
	 * 
	 * @return
	 * @throws Exception
	 */
//	@RequestMapping("/member/pwConfrimForm")
//	public String pwConfrimForm() throws Exception {
//		return "/member/pwConfrimForm";
//	}

	// /**
	// * 내정보 수정 폼
	// *
	// * @return
	// * @throws Exception
	// */
	// @RequestMapping(value="member/infoUpdateForm" ,method=RequestMethod.POST)
	// public String memberInfoForm(Model model,HttpServletRequest request)
	// throws Exception {
	// MemberBean memberBean = SessionUtil.getMemberBean(request);
	// switch (memberBean.getMbTypeCd()) {
	// // 슈퍼 관리자
	// case CodeConstant.MB_TYPE_CD_01:
	// return "/member/IndInfoUpdateForm";
	// //일반관리자
	// case CodeConstant.MB_TYPE_CD_02:
	// return "/member/IndInfoUpdateForm";
	// //구인자 (기업)
	// case CodeConstant.MB_TYPE_CD_03:
	// return "/member/LicenseInfoUpdateForm";
	// //구직자 (개인)
	// case CodeConstant.MB_TYPE_CD_04:
	// return "/member/IndInfoUpdateForm";
	// }
	// return "/main/index";
	// }

	/**
	 * 회원 탈퇴 폼
	 * 
	 * @return
	 * @throws Exception
	 */
//	@RequestMapping(value = "member/deleteForm")
//	public String deleteForm() throws Exception {
//		return "/member/deleteForm";
//	}

	/**
	 * 회원 정보 수정
	 * 
	 * @param memberBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
//	@RequestMapping(value = "member/updateMemberAjax", method = RequestMethod.POST)
//	@ResponseBody
//	public Map<String, Object> updateMemberAjax(MemberBean memberBean, HttpServletRequest request) throws Exception {
//
//		Map<String, Object> map = new HashMap<String, Object>();
//		String result = null;
//		String resultMsg = null;
//
//		try {
//
//			memberService.updateMember(memberBean);
//			result = Constants.OK;
//			resultMsg = "회원 정보 수정 성공";
//			memberBean = memberService.selectMember(memberBean);
//			SessionUtil.setMemberBean(request, memberBean);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			result = Constants.FAIL;
//			resultMsg = "회원 정보 수정 실패";
//		}
//
//		map.put("resultMsg", resultMsg);
//		map.put("result", result);
//
//		return map;
//	}

	/**
	 * 로그인
	 * 
	 * @param memberBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/member/loginAjax")
	@ResponseBody
	public Map<String, Object> loginAjax(MemberBean memberBean, HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String result = null;
		String resultMsg = null;
		int resultCnt = -1;
		try {
			resultCnt = memberService.login(memberBean);
			if (resultCnt == 1) {
				result = Constants.OK;
				resultMsg = "로그인 성공";
				memberBean = memberService.selectMember(memberBean);
				// 세션에 userBean으로 member 정보 저장
				SessionUtil.setMemberBean(request, memberBean);
			} else {
				result = Constants.FAIL;
				resultMsg = "아이디와 비밀번호를 확인하세요";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = Constants.FAIL;
			resultMsg = "시스템 에러";
		}
		map.put("result", result);
		map.put("resultMsg", resultMsg);
		return map;
	}

	
	/**
	 * 로그아웃
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("member/logoutAjax")
	@ResponseBody
	public Map<String, Object> logoutAjax(HttpServletRequest request) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		SessionUtil.removeMemberBean(request);

		resultMap.put("result", Constants.OK);
		resultMap.put("resultMsg", "정상적으로 로그아웃 되셨습니다.");

		return resultMap;
	}

	/**
	 * 회원 탈퇴
	 * 
	 * @param memberBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
//	@RequestMapping("member/memberDeleteAjax")
//	@ResponseBody
//	public Map<String, Object> memberDeleteAjax(MemberBean memberBean, HttpServletRequest request) throws Exception {
//		Map<String, Object> map = new HashMap<String, Object>();
//		String result = null;
//		String resultMsg = null;
//		try {
//			memberService.deleteMember(memberBean);
//			result = Constants.OK;
//			resultMsg = "회원탈퇴 성공";
//			SessionUtil.removeMemberBean(request);
//		} catch (Exception e) {
//			e.printStackTrace();
//			result = Constants.FAIL;
//			resultMsg = "시스템 에러";
//		}
//
//		map.put("resultMsg", resultMsg);
//		map.put("result", result);
//
//		return map;
//	}

	/**
	 * 회원 목록
	 * 
	 * @return
	 */
//	@RequestMapping(value = "board/memberList")
//	public String memberList(HttpServletRequest request, Model model) {
//		MemberBean chkmember = SessionUtil.getMemberBean(request);
//		List<MemberBean> memberList = null;
//		String resultPath = "/member/loginForm";
//		try {
//			model.addAttribute("memberList", memberList);
////			model.addAttribute("pagingBean", pagingBean);
//			resultPath = "/member/memberList";
//		} catch (Exception e) {
//			e.printStackTrace();
//			SessionUtil.removeMemberBean(request);
//		}
//		return resultPath;
//	}
}

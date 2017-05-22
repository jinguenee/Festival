package com.test.web.member.service;

import java.util.List;

import com.test.web.member.bean.MemberBean;

public interface MemberService  {
	public int insertMember(MemberBean bean) throws Exception; // 회원가입
	public MemberBean selectMember(MemberBean bean) throws Exception; // 회원조회
	public List<MemberBean> selectMemberList(MemberBean bean) throws Exception; // 회원전체조회
} // end of interface

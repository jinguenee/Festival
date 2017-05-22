package com.test.web.member.dao;

import java.util.List;

import com.test.web.member.bean.MemberBean;

public interface MemberDao {
	public int insertMember(MemberBean bean); // 회원가입
	public MemberBean selectMember(MemberBean bean); // 회원조회
	public List<MemberBean> selectMemberList(MemberBean bean); // 회원전체조회
} // end of interface

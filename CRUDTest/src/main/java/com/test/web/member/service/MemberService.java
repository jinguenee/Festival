package com.test.web.member.service;

import java.util.List;

import com.test.web.member.bean.MemberBean;

public interface MemberService {
	public int insertMember(MemberBean memberBean) throws Exception;
	
	public int chkMemberId(String memberId) throws Exception;
	
	public MemberBean selectMember(MemberBean memberBean) throws Exception;
	
	public List<MemberBean> selectMemberList(MemberBean memberBean) throws Exception;
	
	public int updateMember(MemberBean memberBean) throws Exception;
	
	public int deleteMember(MemberBean memberBean) throws Exception;
}

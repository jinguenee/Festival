﻿package com.yg.festival.member.dao;

import java.util.List;

import com.yg.festival.member.bean.MemberBean;

/**
 * 멤버 dao
 * @author KYG
 */
public interface MemberDao {
	/** 회원가입 **/
	public int insertMember(MemberBean bean);
	
	/** 로그인 **/
	public int login(MemberBean memberBean);
	
	/** 회원정보를 조회해서 가져온다. **/
	public MemberBean selectMember(MemberBean bean);
	
	/** 회원정보를 조회해서 리스트로 가져온다. **/
	public List<MemberBean> selectMemberList(MemberBean memberBean);
	
	/** 회원정보를 수정한다. **/
	public int updateMember(MemberBean memberBean);
	
	/** 회원 삭제 **/
	public int deleteMember(MemberBean memberBean);
	
	/** 아이디 중복 체크 **/
	public int chkId(MemberBean memberBean);
	
	/** 회원 아이디 찾기 **/
	public MemberBean selectMemberId(MemberBean memberBean);
	
	/** 회원 비밀번호 찾기 **/
	public MemberBean selectMemberPw(MemberBean memberBean);
	
	/** 회원정보 리스트**/
//	public List<MemberBean> memberList(PagingBean pagingBean);
}

package com.test.web.member.dao;

import java.util.List;

import com.test.web.member.bean.MemberBean;

public interface MemberDao {
	/** 회원 가입 */
	public int insertMember(MemberBean memberBean);

	/** 회원 아이디 중복 체크 */
	public int chkMemberId(String memberId);
	
	/** 회원 1명 조회 */
	public MemberBean selectMember(MemberBean memberBean);
	
	/** 회원 여러명 조회 */
	public List<MemberBean> selectMemberList(MemberBean memberBean);
	
	/** 회원 정보 업데이트 */
	public int updateMember(MemberBean memberBean);
	
	/** 회원 삭제 */
	public int deleteMember(MemberBean memberBean);
}

package com.test.web.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.web.member.bean.MemberBean;
import com.test.web.member.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	/** 회원 가입 */
	public int insertMember(MemberBean memberBean) throws Exception {
		return memberDao.insertMember(memberBean);
	}
	/** 회원 아이디 중복 체크 */
	public int chkMemberId(String memberId) throws Exception {
		return memberDao.chkMemberId(memberId);
	}
	public MemberBean selectMember(MemberBean memberBean) throws Exception {
		return memberDao.selectMember(memberBean);
	}
	@Override
	public List<MemberBean> selectMemberList(MemberBean memberBean) throws Exception {
		return memberDao.selectMemberList(memberBean);
	}
	@Override
	public int updateMember(MemberBean memberBean) throws Exception {
		return memberDao.updateMember(memberBean);
	}
	@Override
	public int deleteMember(MemberBean memberBean) throws Exception {
		return memberDao.deleteMember(memberBean);
	}
}

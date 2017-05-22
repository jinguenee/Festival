package com.test.web.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.web.member.bean.MemberBean;
import com.test.web.member.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public MemberBean selectMember(MemberBean bean) throws Exception { // 회원조회
		return memberDao.selectMember(bean);
	}
	@Override
	public List<MemberBean> selectMemberList(MemberBean bean) throws Exception { // 회원전체조회
		return memberDao.selectMemberList(bean);
	}
	@Override
	public int insertMember(MemberBean bean) throws Exception { // 회원가입
		return memberDao.insertMember(bean);
	}
} // end of class

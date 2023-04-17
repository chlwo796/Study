package com.woori.myhome.member;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Resource(name="memberDao")
	MemberDao dao;
	
	
	@Override
	public boolean isDuplicate(MemberDto dto) {
		
		return dao.isDuplicate(dto);
	}

	@Override
	public void insert(MemberDto dto) {
		dao.insert(dto);
	}

	@Override
	public MemberDto logon(MemberDto dto) {
		return dao.logon(dto);
	}
}






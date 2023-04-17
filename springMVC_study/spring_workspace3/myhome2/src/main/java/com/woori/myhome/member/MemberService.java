package com.woori.myhome.member;

public interface MemberService {
	boolean isDuplicate(MemberDto dto);
	void insert(MemberDto dto);
	MemberDto logon(MemberDto dto);
}

package com.test;

public interface MemberRepository {
	public void save(Member member);
	public Member searchById(Long memberId);
}

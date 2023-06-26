package com.test;

public class MemberServiceImpl implements MemberService{
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	@Override
	public void join(Member member) {
		memberRepository.save(member);
		
	}@Override
	public Member searchMember(Long memberId) {
		return memberRepository.searchById(memberId);
	}
}

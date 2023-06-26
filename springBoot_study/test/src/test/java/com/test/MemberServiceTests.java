package com.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTests {

	MemberService memberService = new MemberServiceImpl(); 
	
	@Test
	void register() {
		Member member = new Member(1L, "홍길동", Grade.VIP);
		memberService.join(member);
		Member searchMember = memberService.searchMember(1L);
		
		Assertions.assertThat(member).isEqualTo(searchMember);
	}
}
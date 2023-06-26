package com.test;
// 회원서비스 : MemberService.java(인터페이스)
// 회원서비스 구현 : MemberServiceImpl.java
// 멤버 리포지토리 : MemberRepository.java(인터페이스)
// 멤버 리포지토리 구현 : MemoryMemberRepository.java

// DTO, 회원엔티티
public class Member {
	private Long id;
	private String name;
	private Grade grade;
	
	public Member(Long id, String name, Grade grade) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}
}

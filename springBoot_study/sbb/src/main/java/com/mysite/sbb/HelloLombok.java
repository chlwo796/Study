package com.mysite.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor	// 해당 속성을 필요로하는 생성자 자동 생성
// 이후 진행되는 챕터에서 의존성 주입(Dependency Injection)시 사용
@Getter
@Setter	// final 변수선언해서 의미가 없는 어노테이션이다.
public class HelloLombok {
	// final로 설정된 변수 -> @RequiredArgsConstructor 어노테이션 생성자 속성
	private final String hello;	
	private final int lombok;
	
	public static void main(String[] args) {
		HelloLombok helloLombok = new HelloLombok("헬로", 5);
		System.out.println(helloLombok.getHello());
		System.out.println(helloLombok.getLombok());
	}
}

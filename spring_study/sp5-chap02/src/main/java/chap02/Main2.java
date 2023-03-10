package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		Greeter g1 = ctx.getBean("greeter1", Greeter.class);
		Greeter g2 = ctx.getBean("greeter2", Greeter.class);

		System.out.println("(g1 == g2) = " + (g1 == g2));
		// g1과 g2는 같은 객체임을 의미
		// 별도 설정을 하지 않을 경우 슬프링은 한 개의 빈 객체만을 생성하며, 이 때 빈 객체는 싱글톤 범위를 갖는다.
		// 스프링은 기본적으로 하나의 @Bean 어노테이션에 대해 한 개의 빈 객체를 생성
		ctx.close();
	}
}
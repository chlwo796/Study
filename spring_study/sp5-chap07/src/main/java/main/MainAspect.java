package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chap07.Calculator;
import config.AppCtx;

public class MainAspect {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		Calculator cal = ctx.getBean("calculator",Calculator.class);
		// "calculator"빈의 실제 타입은 Calculator를 상속한 프록시 타입이므로
		// RecCalculator로 타입변환을 할 수 없다.(익셉션발생)
		long fiveFact = cal.factorial(5);
		System.out.println("cal.factorial(5) = " + fiveFact);
		System.out.println(cal.getClass().getName());
		ctx.close();
	}
}

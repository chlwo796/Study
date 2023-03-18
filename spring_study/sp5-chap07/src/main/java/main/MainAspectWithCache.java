package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chap07.Calculator;
import config.AppCtxWithCache;

public class MainAspectWithCache {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtxWithCache.class);
		Calculator cal = ctx.getBean("calculator",Calculator.class);
		// "calculator"빈의 실제 타입은 Calculator를 상속한 프록시 타입이므로
		// RecCalculator로 타입변환을 할 수 없다.(익셉션발생)
		cal.factorial(5);	// cacheAspect -> ExeTimeAspect -> 대상 객체
		cal.factorial(5);	// joinPoint.proceed()를 실행하지 않으므로 ExeTimeAspect나 실제 객체 실행x
		cal.factorial(7);
		cal.factorial(7);

		ctx.close();
	}
}

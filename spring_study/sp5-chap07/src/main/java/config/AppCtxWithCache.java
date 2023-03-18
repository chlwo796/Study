package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aspect.CacheAspect;
import aspect.ExeTimeAspect;
import chap07.Calculator;
import chap07.RecCalculator;

@Configuration
@EnableAspectJAutoProxy
// 인터페이스가 아닌 클래스를 이용하여 프록시를 생성하고 싶은 경우,
// @EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppCtxWithCache {
	@Bean
	public ExeTimeAspect exeTimeAspect() {
		return new ExeTimeAspect();
	}

	@Bean
	public Calculator calculator() {
		// AOP 적용시 RecCalculator가 상속받은 Calculator 인터페이스를 이용해서 프록시 생성
		return new RecCalculator();
	}

	@Bean
	public CacheAspect cacheAspect() {
		return new CacheAspect();
	}
}
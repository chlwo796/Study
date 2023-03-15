package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.Client;
import spring.Client2;

@Configuration
public class AppCtx {
	@Bean
	// 특정 빈을 프로토타입으로 지정 getBean()메소드가 매번 새로운 객체를 생성하여 리턴한다.
	// 프로토타입의 경우 스프링컨테이너가 생성한 빈 객체의 소멸메소드를 실행하지는 않으므로, 빈객체의 소멸 처리를 코드에서 직접 하여야한다.
	@Scope("prototype")
	public Client client() {
		Client client = new Client();
		client.setHost("host");
		// 해당 클래스는 InitializingBean 인터페이스를 구현했으므로 별도 설정 없이
		// afterPropertiesSet() 메소드를 스프링 컨테이너가 실행한다.
		// 이 경우 초기화메소드가 두번 실행되는데, 직접 설정할 경우 두번 호출되지 않도록 주의해야한다.
//		client.afterPropertiesSet();
		return client;
	}

	// 외부에서 제공받은 클래스를 스프링 빈 객체로 설정하고 싶은 경우
	// initMethod, destroyMethod 속성에 지정한 메소드는 파라미터가 없어야 하며, 파라미터가 존재할 경우 스프링 익셉션 발생
	@Bean(initMethod = "connect", destroyMethod = "close")
	// 초기화 = connect(), 소멸 = close()
	@Scope("singleton")
	// 특정 빈을 명시적으로 싱글톤으로 지정
	public Client2 client2() {
		Client2 client = new Client2();
		client.setHost("host");
		// 설정메소드에서 직접 해당메소드를 호출하여 초기화할 수도 있다.
//		client.connect();
		return client;
	}
}

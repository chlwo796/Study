package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.MemberDao;
import spring.MemberPrinter;

@Configuration
// 두개 이상 설정파일 사용할 경우 @Import
// @Import를 사용하면, 스프링 컨테이너를 생성할 때 AppConf2 설정 클래스를 지정할 필요가 없다.
// @Import({AppConf1.class, AppConf2.class}) 와 같이 배열을 이용해서 2개 이상도 가능하다.
// 다중 @Import를 사용하여 이 후 다른 설정클래스를 추가해도 MainForSpring을 수정할 필요가 없다.
// AnnotationConfigApplicationContext를 생성하는 코드는 최상위 설정 클래스 한 개만 사용하면 된다.
@Import(AppConf2.class)
public class AppConfImport {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}

	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
}
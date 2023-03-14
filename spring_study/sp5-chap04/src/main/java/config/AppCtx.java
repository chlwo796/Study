package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.MemberSummaryPrinter;
import spring.VersionPrinter;

@Configuration
@ComponentScan(basePackages = { "spring" })
// spring 패키지와 하위 패키지에 속한 클래스를 스캔 대상으로 한다.
public class AppCtx {
//	@Bean
//	public MemberDao memberDao() {
	// 스캔등록했던 빈 이름과 수동 등록한 빈이름이 일치할 경우,
	// 수동등록한 빈이 우선한다. 즉, 이 클래스에서 수동선언한 빈 한개만 존재한다.
//		return new MemberDao();
//	}
//	@Bean
//	public MemberDao memberDao2() {
	// 같은 타입이지만 이름이 다른 수동등록한 빈의 경우, 컨테이너에서 각각 객체가 생성되므로
	// @Qualifier 어노테이션을 사용하여 각 알맞은 빈을 선택해주어야한다.
//		return new MemberDao();
//	}

	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		// 의존을 주입하지 않아도 스프링이 @Autowired가 붙은 필드에 해당 타입의 빈 객체를 찾아서 주입한다.
		// @Autowired 어노테이션을 설정할 필드에 알맞은 빈 객체가 주입되지 않았다면
		// 해당 기능을 실행할때(의존주입될때) NullPointerException이 발생하게된다.
		return pwdSvc;
	}

	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}

	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}

	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
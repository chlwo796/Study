package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
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
public class AppCtx {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}

	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService();
	}

	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		// 의존을 주입하지 않아도 스프링이 @Autowired가 붙은 필드에 해당 타입의 빈 객체를 찾아서 주입한다.
		// @Autowired 어노테이션을 설정할 필드에 알맞은 빈 객체가 주입되지 않았다면
		// 해당 기능을 실행할때(의존주입될때) NullPointerException이 발생하게된다.
		return pwdSvc;
	}

//	@Bean
//	public MemberPrinter memberPrinter() {
//		return new MemberPrinter();
//	}
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
	public MemberListPrinter listPrinter() {
		// 생성자 방식
		// 빈 객체를 생성하는 시점에 모든 의존 객체가 주입된다.
		// 파라미터 수가 많을 경우 각 인자가 어떤 의존 객체를 설정하는지 알아내려면 생성자의 코드를 확인해야 한다.
		return new MemberListPrinter();
	}

	@Bean
	public MemberInfoPrinter infoPrinter() {
		// set 메소드 DI 방식
		// 세터 메소드 이름을 통해 어떤 의존 객체가 주입되는지 알 수 있다.
		// 필요한 의존 객체를 전달하지 않아도 빈 객체가 생성되기 때문에, 객체를 사용하는 시점에 NullpointerException이 발생할 수
		// 있다.
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//		infoPrinter.setMemberDao(memberDao());
//		infoPrinter.setPrinter(memberPrinter());
		// 의존을 주입했지만, 자동 주입 대상일 경우
		// 자동주입을 통해 일치하는 빈을 찾아 주입한다.(수동주입x)
		// 스프링의 자동주입 기능을 사용했다면, 일관되게 사용하는 것이 중요하다.
		infoPrinter.setPrinter(memberPrinter2());
		// MemberInfoPrinter클래스에 각 set메소드에 @Autowired 어노테이션
		return infoPrinter;
	}

	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}

}

package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.VersionPrinter;

@Configuration
public class AppCtxNoMemberPrinterBean {
	// 주입 객체가 꼭 스프링 빈이어야 할 필요는 없다.
	// 객체를 스프링 빈으로 등록하지 않았을 경우, 스프링 컨테이너가 객체를 관리하지 않는다.
	// 따라서 MemberPrinter printer = ctx.getBean(MemberPrinter.class); 는 예외를 발생시킨다.

	// 최근에는 의존 자동 주입 기능을 프로젝트 전반에 걸쳐 사용하는 추세이므로 의존 주입 대상은 스프링 빈으로 등록하는 것이 보통이다.
	private MemberPrinter printer = new MemberPrinter();

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}

	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}

	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}

	@Bean
	public MemberListPrinter listPrinter() {
		// MemberPrinter 객체를 생성한 후 printer 필드에 할당하고 그 필드를 사용해서 listPrinter, infoPrinter
		// 빈을 생성한다.
		return new MemberListPrinter(memberDao(), printer);
	}

	@Bean
	public MemberInfoPrinter infoPrinter() {
		// MemberPrinter 객체를 생성한 후 printer 필드에 할당하고 그 필드를 사용해서 listPrinter, infoPrinter
		// 빈을 생성한다.
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao());
		infoPrinter.setPrinter(printer);
		return infoPrinter;
	}

	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}

	// 같은 타입의 빈 객체 두개가 존재
	@Bean
	public VersionPrinter oldVersionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(4);
		versionPrinter.setMinorVersion(3);
		return versionPrinter;
	}

}

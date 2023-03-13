package spring;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

public class MemberPrinter {
	@Autowired(required = false) // 필드에도 사용 가능
	private DateTimeFormatter dateTimeFormatter;
	// Optional 필드를 사용한 예 = print1()메소드
//	@Autowired
//	private Optional<DateTimeFormatter> formatterOpt;
//
//	public void print1(Member member) {
//		DateTimeFormatter dateTimeFormatter = formatterOpt.orElse(null);
//		if (dateTimeFormatter == null) {
//			System.out.printf("회원 정보: 아이디=%s, 이메일=%s, 이름=%s, 등록일=%tF\n", member.getId(), member.getEmail(),
//					member.getName(), member.getRegisterDateTime());
//		} else {
//			System.out.printf("회원 정보: 아이디=%s, 이메일=%s, 이름=%s, 등록일=%tF\n", member.getId(), member.getEmail(),
//					member.getName(), dateTimeFormatter.format(member.getRegisterDateTime()));
//		}
//	}

	public void print(Member member) {
		if (dateTimeFormatter == null) {
			System.out.printf("회원 정보: 아이디=%s, 이메일=%s, 이름=%s, 등록일=%tF\n", member.getId(), member.getEmail(),
					member.getName(), member.getRegisterDateTime());
		} else {
			System.out.printf("회원 정보: 아이디=%s, 이메일=%s, 이름=%s, 등록일=%tF\n", member.getId(), member.getEmail(),
					member.getName(), dateTimeFormatter.format(member.getRegisterDateTime()));
		}
	}

	@Autowired
	// 스프링5,자바8 Optional 적용(required = false 조건없이 가능)
	public void setDateTimeFormatter(Optional<DateTimeFormatter> formatterOpt) {
		if (formatterOpt.isPresent()) {
			this.dateTimeFormatter = formatterOpt.get();
		} else {
			this.dateTimeFormatter = null;
		}
	}

	@Autowired(required = false)
//	 자동주입할 대상이 필수가 아닌 경우
//	 매칭되는 빈이 없어도 익셉션 발생x, 자동주입실행x
	public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}

	@Autowired
	// autowired 어노테이션을 붙인 세터 메소드에 @Nullable 어노테이션을 의존 주입 대상 파라미터에 붙인다.
	// 스프링 컨테이너는 세터메소드를 호출할 때 자동주입할 빈이 존재하면 빈을 전달하고, 없으면 null을 전달한다.
	// required=false 와의 다른점은 빈이 존재하지 않아도 해당 메소드가 실행된다.
	public void setDateTimeFormatter1(@Nullable DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}
}
package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
	// 해당 클래스에서 의존자동주입 어노테이션을 활용하면
	// 스프링 설정 클래스에서의 @Bean 메소드에서 의존 주입을 위한 코드를 작성하지 않아도 된다.!
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter printer;

	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(member);
		System.out.println();
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
}

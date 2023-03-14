package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberListPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;

	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		super();
		this.memberDao = memberDao;
		this.printer = printer;
	}

	public MemberListPrinter() {
		// TODO Auto-generated constructor stub
	}

	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));
	}

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Autowired
	@Qualifier("summaryPrinter")
	public void setMemberPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	// setMemberPrinter의 매개변수타입을 MemberSummaryPrinter를 사용하도록 수정하여도 2개이상의 자동주입오류를 피할 수 있다.
}

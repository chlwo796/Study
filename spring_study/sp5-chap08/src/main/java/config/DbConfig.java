package config;

import org.apache.tomcat.jdbc.pool.DataSource;
// 커넥션 풀 기능을 제공하는 DataSource 구현 클래스
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;

@Configuration
@EnableTransactionManagement
public class DbConfig {
	@Bean(destroyMethod = "close") // 커넥션 풀에 보관된 Connection을 얻는다.
	// 커넥션 풀을 사용하는 이유는 성능 때문이다.
	// 미리 커넥션을 생성했다가 필요할 때 커넥션을 꺼내 쓰므로 커넥션을 구하는 시간이 줄어 전체 응답 시간도 짧아진다.
	public DataSource dataSource() {
		DataSource ds = new DataSource(); // DataSource 객체생성
		ds.setDriverClassName("com.mysql.jdbc.Driver"); // JDBC 드라이버 클래스 지정, MYSQL 드라이버 클래스 사용
		ds.setUrl("jdbc:mysql://localhost/spring5fs?autoReconnect=true"); // JDBC URL 지정
		ds.setUsername("spring5"); // 사용자 계정, 암호 지정
		ds.setPassword("spring5");
		ds.setInitialSize(2); // 커넥션 풀을 초기화할 때 최소 수준의 커넥션을 미리 생성하는 것이 좋다.
		ds.setMaxIdle(10);
		ds.setMaxActive(10); // 활성 상태가 가능한 최대 커넥션 수 지정
		ds.setTestWhileIdle(true); // 유휴 커넥션 검사, 유휴 시간이 지나면 커넥션이 끊어진 채로 커넥션 풀 속에 남아있다.->추후 익셉션발생, 주기적으로 확인 필요
		ds.setMinEvictableIdleTimeMillis(1000 * 60 * 3); // 최소 유휴 시간 3분
		ds.setTimeBetweenEvictionRunsMillis(1000 * 10); // 10초 주기로 검사

		return ds;
	}

	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}

	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}

	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}

	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}

	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao(), memberPrinter());
	}

	@Bean
	public MemberInfoPrinter memberInfoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao());
		infoPrinter.setPrinter(memberPrinter());
		return infoPrinter;
	}

}

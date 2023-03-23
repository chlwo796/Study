package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;

	public MemberDao(DataSource dataSource) {
		// JdbcTemplate을 이용하여 DataSource나 Connection, Statement, ResultSet을 이용하지 않고 간편하게
		// 쿼리를 실행한다.
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query("select * from MEMBER where EMAIL = ?", new MemberRowMapper(), email);
		return results.isEmpty() ? null : results.get(0);
	}

	public void insert(Member member) {
		// GeneratedKeyHolder 객체 생성, 자동 생성된 키 값을 구해주는 KeyHolder 구현 클래스이다.
		KeyHolder keyHolder = new GeneratedKeyHolder();
		// update()는 PreparedStatementCreator 객체와 KeyHolder 객체를 파라미터로 한다.
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// 두번째 파라미터는 자동 생성되는 키 컬럼 목록을 지정할 때 사용
				// MEMBER 테이블은 ID 컬럼이 자동 증가 키 컬럼
				PreparedStatement pstmt = con.prepareStatement(
						"insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) values (?, ?, ?, ?)",
						new String[] { "ID" });
				// 각 인덱스 파라미터 값 설정
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			};
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
	}

	public void update(Member member) {
//		 대부분 많이 사용
		jdbcTemplate.update("update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?", member.getName(),
				member.getPassword(), member.getEmail());

		// 직접 인덱스 파라미터의 값을 설정해야 하는 경우, PreparedStatementCreator를 인자로 받는 메소드르 이용한다.
//		jdbcTemplate.update(new PreparedStatementCreator() {
//
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
//				PreparedStatement pstmt = con
//						.prepareStatement("insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) values (?, ?, ?, ?)");
//				// 각 인덱스 파라미터 값 설정
//				pstmt.setString(1, member.getEmail());
//				pstmt.setString(2, member.getPassword());
//				pstmt.setString(3, member.getName());
//				pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
//				// 생성한 PreparedStatement 객체 리턴
//				return pstmt;
//			}
//		});
	}

	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query("select * from MEMBER", new MemberRowMapper());
		return results;
	}

	public int count() {
		// queryForObject() = 쿼리 실행 결과 행이 한개일 경우에 사용, 두번째 파라미터는 컬럼을 읽어올 때 사용할 타입
		// 결과 행이 정확히 한 행이 아닐 경우 query() 메소드를 사용한다.
		// 인덱스 파라미터가 존재하면 파라미터의 값을 가변 인자로 전달
		Integer count = jdbcTemplate.queryForObject("select count(*) from MEMBER", Integer.class);
		return count;
	}
}
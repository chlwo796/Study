package spring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemberRowMapper implements RowMapper<Member> {
	// RowMapper<Member>를 여러곳에서 구현한다면, 클래스를 따로 만들어서 코드 중복을 막을 수 있다. 
	// MemberDao의 selectByEmail(), sellectAll() 참고 
	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member member = new Member(rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("NAME"),
				rs.getTimestamp("REGDATE").toLocalDateTime());
		member.setId(rs.getLong("ID"));
		return member;
	}
}

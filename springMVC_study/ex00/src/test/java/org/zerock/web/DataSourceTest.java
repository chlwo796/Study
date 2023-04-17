package org.zerock.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 아래 클래스 실행하는 방법은 Junit4로 한다
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" }) // 아래 클래스의 컨테이너(빈) 위치는																					// root-context.xml에																							// 써있다.
public class DataSourceTest {

	@Autowired
	private DataSource ds;

	@Test
	public void testConnection() {
		Connection conn;
		try {

			conn = ds.getConnection();
			System.out.println(conn);
			System.out.println("연결 성공");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

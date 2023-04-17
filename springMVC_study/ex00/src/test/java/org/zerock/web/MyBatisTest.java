package org.zerock.web;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //아래 클래스 실행하는 방법은 Junit4로 한다
@ContextConfiguration( locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyBatisTest {
   
	@Autowired
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testFactory() {
		System.out.println( sqlFactory +" ~~~" );
	}
	
	@Test
	public void testSession() {
		SqlSession session = sqlFactory.openSession();
		System.out.println( session +"!!!" );
	}
	
}

package sample.spring.yse;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // 스프링이 관리한다 저장소 용도로 사용하는 클래스이다 라고 지정함
public class BookDAO {

	// 필드 선언
	@Autowired // 자동주입해라
	SqlSessionTemplate sqlSessionTemplate;

	// 메소드 삽입에 관련 역할을 하는 메소드 insert- username
	public int insert(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("book.insert", map);
	}
	
	public Map<String, Object> selectDetail(Map<String, Object> map) {
		// 데이터를 한 행만 가져올 경우 selectOne() 메소드 사용
		// 쿼리 결과 행수 = 0 일 경우 null return, 여러개면, TooManyResultsException 예외
		return this.sqlSessionTemplate.selectOne("book.select_detail", map);
	}
}

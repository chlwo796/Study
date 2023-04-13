package sample.spring.yse;

import java.util.List;
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

	public int update(Map<String, Object> map) {
		// insert()와 사용법 동일, 첫번째 파라미터 = 쿼리ID, 두번째 파라미터 = 쿼리파라미터
		// return = 영향받은 행 수
		return this.sqlSessionTemplate.update("book.update", map);
	}

	public int delete(Map<String, Object> map) {
		// 데이터 삭제 Dao 메소드, update()와 사용법 동일
		return this.sqlSessionTemplate.delete("book.delete", map);
	}
	// 책 목록 만드는 메소드
	public List<Map<String, Object>> selectList(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("book.select_list", map);
	}
}
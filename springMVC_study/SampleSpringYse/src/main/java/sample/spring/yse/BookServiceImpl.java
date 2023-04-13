package sample.spring.yse;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 서비스 클래스(비즈니스클래스-진짜 동작시키는 클래스)
public class BookServiceImpl implements BookService {

	@Autowired // BookDAO라는 객체를 자동으로 주입한다. BookDAO 클래스를 사용할 수 있다 new BookDAO();
	BookDAO bookDao;

	@Override
	public String create(Map<String, Object> map) {
		int affectRowCount = this.bookDao.insert(map);
		if (affectRowCount == 1) {
			return map.get("book_id").toString();
		}
		return null;
	}

	@Override
	public Map<String, Object> detail(Map<String, Object> map) {
		// bookDao의 selectDetail 메소드 구현
		return this.bookDao.selectDetail(map);
	}

	// 수정기능메소드 구현
	@Override
	public boolean edit(Map<String, Object> map) {
		int affectRowCount = this.bookDao.update(map);
		// 수정의 경우 입력과는 다르게 PK를 가져오거나 하는 절차 필요 없음
		// 1개의 행만이 영향받았는지만 체크
		return affectRowCount == 1;
	}

	// 책 삭제기능 메소드 구현
	@Override
	public boolean remove(Map<String, Object> map) {
		int affectRowCount = this.bookDao.delete(map);
		// 수정의 경우 입력과는 다르게 PK를 가져오거나 하는 절차 필요 없음
		// 1개의 행만이 영향받았는지만 체크
		return affectRowCount == 1;
	}
	// 책 목록 출력메소드
	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) {
		return this.bookDao.selectList(map);
	}
}
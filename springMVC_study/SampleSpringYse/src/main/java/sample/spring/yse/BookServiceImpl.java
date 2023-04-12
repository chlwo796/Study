package sample.spring.yse;

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
		return this.bookDao.selectDetail(map);
	}
}
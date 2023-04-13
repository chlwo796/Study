package sample.spring.yse;

import java.util.List;
import java.util.Map;

public interface BookService {
	String create(Map<String, Object> map); // 책 입력메소드

	Map<String, Object> detail(Map<String, Object> map); // 책 상세화면메소드

	boolean edit(Map<String, Object> map);

	boolean remove(Map<String, Object> map);

	List<Map<String, Object>> list(Map<String, Object> map);	// 책목록 메소드

}
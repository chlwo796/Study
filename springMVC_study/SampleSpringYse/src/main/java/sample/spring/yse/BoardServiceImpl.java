package sample.spring.yse;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao boardDao;

	@Override
	public String create(Map<String, Object> map) {
		int affectRowCount = this.boardDao.insert(map);
		if (affectRowCount == 1) {
			System.out.println(affectRowCount + "행이 삽입됨");
			return map.get("no").toString();
		} else {
			return null;
		}
	}
}

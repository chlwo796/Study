package sample.spring.yse;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int insert(Map<String, Object> map) {
		// sqlSessionTemplate 의 insert() 리턴 = int The number of rows affected by the insert.
		return this.sqlSessionTemplate.insert("board.insert", map);
	}
}
package com.woori.myhome.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boardDao2")
public class BoardDaoImpl2 implements BoardDao{

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<BoardDto> getList(BoardDto dto) {
		
		return sm.selectList("Board_getList", dto);
	}

	@Override
	public void insert(BoardDto dto) {
		sm.insert("Board_insert", dto);
		
	}

	@Override
	public BoardDto getView(int id) {
		
		//결고값이 하나일때는 selectOne, null이거나 하나일때 
		return sm.selectOne("Board_getView", id);
	}

	@Override
	public void update(BoardDto dto) {
		sm.update("Board_update", dto);
	}

	@Override
	public void delete(int seq) {
		sm.delete("Board_delete", seq);
		
	}

	@Override
	public int getTotal(BoardDto dto) {
		
		return sm.selectOne("Board_getTotalCount", dto);
	}

}




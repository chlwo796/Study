package com.woori.myhome.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl  implements BoardService{

	@Resource(name="boardDao2")
	BoardDao boardDao;  //스프링이 객체를 주입한다 
	
	@Override
	public List<BoardDto> getList(BoardDto dto) {
		
		return boardDao.getList(dto);
	}

	@Override
	public void insert(BoardDto dto) {

		boardDao.insert(dto);
		
	}

	@Override
	public BoardDto getView(int id) {
		
		return boardDao.getView(id);
	}

	@Override
	public void update(BoardDto dto) {
		boardDao.update(dto);
		
	}

	@Override
	public void delete(int seq) {
		boardDao.delete(seq);
		
	}

	@Override
	public int getTotal(BoardDto dto) {
		
		return boardDao.getTotal(dto);
	}

}



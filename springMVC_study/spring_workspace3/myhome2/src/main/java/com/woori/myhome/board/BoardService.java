package com.woori.myhome.board;

import java.util.List;
//서비스에서 트랜잭션처리를 한다 
//하나의 서비스는 여러개의 Dao를 소유할 수 있다
//Dao 는 테이블 하나당 하나씩 만든다. 

public interface BoardService {
	List<BoardDto> getList(BoardDto dto);
	void insert(BoardDto dto);
	BoardDto getView(int id);
	void update(BoardDto dto);
	void delete(int seq);
	int getTotal(BoardDto dto);
}

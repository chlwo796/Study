package com.woori.myhome.board;

import java.util.List;

//xml 파일에 <bean id="boardDao" class="com.woori.myhome.board.BoardDao" >

//DB에서 데이터를 직접 읽고 쓰는 일을 담당 
public interface BoardDao {
	List<BoardDto> getList(BoardDto dto);
	void insert(BoardDto dto);
	BoardDto getView(int id);
	void update(BoardDto dto);
	void delete(int seq);
	int getTotal(BoardDto dto);
	
}

package com.woori.myhome.board;

import java.util.List;

//xml ���Ͽ� <bean id="boardDao" class="com.woori.myhome.board.BoardDao" >

//DB���� �����͸� ���� �а� ���� ���� ��� 
public interface BoardDao {
	List<BoardDto> getList(BoardDto dto);
	void insert(BoardDto dto);
	BoardDto getView(int id);
	void update(BoardDto dto);
	void delete(int seq);
	int getTotal(BoardDto dto);
	
}

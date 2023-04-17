package com.woori.myhome.board;

import java.util.List;
//���񽺿��� Ʈ�����ó���� �Ѵ� 
//�ϳ��� ���񽺴� �������� Dao�� ������ �� �ִ�
//Dao �� ���̺� �ϳ��� �ϳ��� �����. 

public interface BoardService {
	List<BoardDto> getList(BoardDto dto);
	void insert(BoardDto dto);
	BoardDto getView(int id);
	void update(BoardDto dto);
	void delete(int seq);
	int getTotal(BoardDto dto);
}

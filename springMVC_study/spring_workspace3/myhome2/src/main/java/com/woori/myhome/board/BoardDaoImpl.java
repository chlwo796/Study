package com.woori.myhome.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

//@Repository("boardDao")  //BoardDaoImpl��ü�� ���� �ĺ����� boardDao �� ���ּ��� �� �ĺ����� �̿��ؼ� ������ �ٸ� Ŭ������ ��ü�� �����Ѵ�(DI)
public class BoardDaoImpl implements BoardDao{

	//ctrl-shift-o �� ������ �ѹ��� import �ȴ�
	List<BoardDto> list = new ArrayList<BoardDto>();
	
	
	public BoardDaoImpl() {
		super();//�θ������ ȣ��
		for(int i=0; i<10; i++)
		{
			list.add( new BoardDto(i+"", "����"+i, "�ۼ���"+i, "����"+i, "2020-04-19"));
		}
	}

	@Override
	public List<BoardDto> getList(BoardDto dto) {
		
		return list;
	}

	@Override
	public void insert(BoardDto dto) {
		list.add(dto);
		
	}

	@Override
	public BoardDto getView(int id) {
		
		return list.get(id);
	}

	@Override
	public void update(BoardDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int seq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTotal(BoardDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}










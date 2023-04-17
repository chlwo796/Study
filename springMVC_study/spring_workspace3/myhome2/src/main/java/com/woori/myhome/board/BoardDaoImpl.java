package com.woori.myhome.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

//@Repository("boardDao")  //BoardDaoImpl객체를 만들어서 식별값을 boardDao 로 해주세요 이 식별값을 이용해서 스프링 다른 클래스에 객체를 주입한다(DI)
public class BoardDaoImpl implements BoardDao{

	//ctrl-shift-o 를 누르면 한번에 import 된다
	List<BoardDto> list = new ArrayList<BoardDto>();
	
	
	public BoardDaoImpl() {
		super();//부모생성자 호출
		for(int i=0; i<10; i++)
		{
			list.add( new BoardDto(i+"", "제목"+i, "작성자"+i, "내용"+i, "2020-04-19"));
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










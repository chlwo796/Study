package javaChap15.exercise07;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	List<Board> daoList = new ArrayList<Board>();

	public List<Board> getBoardList() {
		daoList.add(new Board("제목2", "내용2"));
		daoList.add(new Board("제목3", "내용3"));
		return daoList;
	}

}

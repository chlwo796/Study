package javaChap15.exercise07;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	List<Board> daoList = new ArrayList<Board>();

	public List<Board> getBoardList() {
		daoList.add(new Board("力格2", "郴侩2"));
		daoList.add(new Board("力格3", "郴侩3"));
		return daoList;
	}

}

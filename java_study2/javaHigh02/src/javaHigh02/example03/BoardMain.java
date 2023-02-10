package javaHigh02.example03;

import java.util.ArrayList;
import java.util.List;

public class BoardMain {
	public static void main(String[] args) {
		List<Board> boardList1 = new ArrayList<Board>();

		boardList1.add(new Board("날씨", "비가와요", "홍길동", "20230210"));
		boardList1.add(new Board("요일", "금요일", "김길동", "20230211"));
		boardList1.add(new Board("주말", "프로젝트", "이길동", "20230212"));

		for (int i = 0; i < boardList1.size(); i++) {
			System.out.print(boardList1.get(i).getSubject() + " ");
			System.out.print(boardList1.get(i).getContent() + " ");
			System.out.print(boardList1.get(i).getWriter() + " ");
			System.out.print(boardList1.get(i).getJoinDate() + " ");
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < boardList1.size(); i++) {
			System.out.print(boardList1.get(i).getJoinDate() + " ");
		}
		System.out.println();

//		게시판 제목에 "요일"이라는 것을 쓴 사람의 이름과 작성일을 검색해보기
//		출력화면 김길동 0211
//		.contains() 혹은 .equals()
		for (int i = 0; i < boardList1.size(); i++) {
			if (boardList1.get(i).getSubject().contains("요일")) {
				System.out.print(boardList1.get(i).getSubject() + " " + boardList1.get(i).getJoinDate());
			}
		}System.out.println();
//		작성일이 0210 것의 게시글의 제목과 내용을 출력하기
		for(int i = 0;i<boardList1.size();i++) {
			if(boardList1.get(i).getJoinDate().equals("20230210")) {
				System.out.print(boardList1.get(i).getSubject() + " " + boardList1.get(i).getContent());
			}
		}
	}
}
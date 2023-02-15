package javaChap15.example01;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Board> list = new ArrayList<Board>();

		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이3"));
		list.add(new Board("제목5", "내용5", "글쓴이4"));
		list.add(new Board("제목6", "내용6", "글쓴이4"));
		
		System.out.println("게시글의 수 : " + list.size());
		System.out.println();
		
		System.out.println(list.get(3).getSubject() + "\t" + list.get(3).getContent() + "\t" + list.get(3).getWriter());
		System.out.println();
		
		for(int i = 0;i<list.size();i++) {
			System.out.println(list.get(i).getSubject() + "\t" + list.get(i).getContent() + "\t" + list.get(i).getWriter());
		}
		// 두번 제거 가능한 이유는 index2 제거 후 index3이었던 데이터가 2로 가기 때문. ArrayList의 특성
		list.remove(2);
		list.remove(2);
		
		System.out.println();
		for(int i = 0;i<list.size();i++) {
			System.out.println(list.get(i).getSubject() + "\t" + list.get(i).getContent() + "\t" + list.get(i).getWriter());
		}
		System.out.println();
		for(Board b : list) {
			System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
		}
	}
}

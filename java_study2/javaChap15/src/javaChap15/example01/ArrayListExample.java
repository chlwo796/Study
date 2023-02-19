package javaChap15.example01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Board> list = new ArrayList<Board>();
		Map<String, Score> map = new HashMap<String, Score>();
		Set<String> set = new HashSet<String>();
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이3"));
		list.add(new Board("제목5", "내용5", "글쓴이4"));
		list.add(new Board("제목4", "내용5", "글쓴이4"));
		list.add(new Board("제목2", "내용5", "글쓴이4"));
		list.add(new Board("제목6", "내용6", "글쓴이4"));
		List<Score> score = new ArrayList<Score>();
		
		Score score1 = new Score(30, 60);
		Score score2 = new Score(40, 90);
		Score score3 = new Score(70, 49);
		Score score4 = new Score(30, 60);
		Score score5 = new Score(50, 80);
		
		
		score.add(new Score(30, 60));
		score.add(new Score(40, 80));
		score.add(new Score(70, 90));
		score.add(new Score(30, 40));
		score.add(new Score(40, 50));
		score.add(new Score(60, 70));

		System.out.println("게시글의 수 : " + list.size());
		System.out.println();

		System.out.println(list.get(3).getSubject() + "\t" + list.get(3).getContent() + "\t" + list.get(3).getWriter());
		System.out.println();

		for (int i = 0; i < list.size(); i++) {
			System.out.println(
					list.get(i).getSubject() + "\t" + list.get(i).getContent() + "\t" + list.get(i).getWriter());
		}
		// 두번 제거 가능한 이유는 index2 제거 후 index3이었던 데이터가 2로 가기 때문. ArrayList의 특성
		list.remove(2);
		list.remove(2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(
					list.get(i).getSubject() + "\t" + list.get(i).getContent() + "\t" + list.get(i).getWriter());
		}
		System.out.println();

//		System.out.println("------------------------");
//		System.out.println("Set 컬렉션으로 변경");
//		Set<Board> set = new HashSet<Board>();
//		set.addAll(list);
//		
//		for(Board s : set) {
//			System.out.println(s.getSubject() + "\t" + s.getContent() + "\t" + s.getWriter());
//		}

		System.out.println("------------------------");
		System.out.println("TreeSet 컬렉션으로 변경");
		TreeSet<Board> treeSet = new TreeSet<Board>();
		treeSet.addAll(list);

		for (Board b : treeSet) {
			System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
		}
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i).getSubject(), score.get(i));
		}
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			System.out.println(key + " " + map.get(key).getScoreA() + " " + map.get(key).getScoreB());
		}
		Scanner sc = new Scanner(System.in);
		String searchName = sc.nextLine();
		for(int i = 0;i<list.size();i++) {
			
		}
	}
}
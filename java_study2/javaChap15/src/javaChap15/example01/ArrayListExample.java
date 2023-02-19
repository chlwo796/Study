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
		list.add(new Board("����1", "����1", "�۾���1"));
		list.add(new Board("����2", "����2", "�۾���2"));
		list.add(new Board("����3", "����3", "�۾���3"));
		list.add(new Board("����4", "����4", "�۾���3"));
		list.add(new Board("����5", "����5", "�۾���4"));
		list.add(new Board("����4", "����5", "�۾���4"));
		list.add(new Board("����2", "����5", "�۾���4"));
		list.add(new Board("����6", "����6", "�۾���4"));
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

		System.out.println("�Խñ��� �� : " + list.size());
		System.out.println();

		System.out.println(list.get(3).getSubject() + "\t" + list.get(3).getContent() + "\t" + list.get(3).getWriter());
		System.out.println();

		for (int i = 0; i < list.size(); i++) {
			System.out.println(
					list.get(i).getSubject() + "\t" + list.get(i).getContent() + "\t" + list.get(i).getWriter());
		}
		// �ι� ���� ������ ������ index2 ���� �� index3�̾��� �����Ͱ� 2�� ���� ����. ArrayList�� Ư��
		list.remove(2);
		list.remove(2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(
					list.get(i).getSubject() + "\t" + list.get(i).getContent() + "\t" + list.get(i).getWriter());
		}
		System.out.println();

//		System.out.println("------------------------");
//		System.out.println("Set �÷������� ����");
//		Set<Board> set = new HashSet<Board>();
//		set.addAll(list);
//		
//		for(Board s : set) {
//			System.out.println(s.getSubject() + "\t" + s.getContent() + "\t" + s.getWriter());
//		}

		System.out.println("------------------------");
		System.out.println("TreeSet �÷������� ����");
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
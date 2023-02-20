package student.Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ScoreManager extends Data {
	// 성적 검색, 전체 성적, 반별 성적
	// 검색 -> 이름
	// 이름 -> 과목 > 점수
	// Map -> <Student,value = 점수
	Scanner sc = new Scanner(System.in);
	String choice;
	boolean run = true;
	List<Score> scoreList;
	Map<Student, Score> map;
	StudentManager studentManager = new StudentManager();
	public ScoreManager() {
		input();
		while (run) {
			System.out.println("---------------------------------------");
			System.out.printf("%-8s%-8s%-8s%-8s\n", "1. 성적검색", "2. 전체성적", "3. 반별 성적", "4. 이전화면");
			System.out.println("---------------------------------------");
			System.out.println("메뉴선택>");
			String choice = sc.nextLine();
			switch (choice) {
			case "1": {
				search();
				break;
			}
			case "2": {
				printAll();
				break;
			}
			case "3": {
				print();
				break;
			}
			case "4": {
				System.out.println("이전 화면으로 돌아갑니다.");
				run = false;
				break;
			}
			default: {
				System.out.println("잘못입력하셨습니다.");
				continue;
			}
			}
		}
	}

	private void input() {
		scoreList = new ArrayList<Score>();
		scoreList.add(new Score(30, 60));
		scoreList.add(new Score(40, 80));
		scoreList.add(new Score(70, 90));
		scoreList.add(new Score(30, 40));
		scoreList.add(new Score(40, 50));
		map = new TreeMap<Student, Score>();
		for (int i = 0; i < studentManager.studentArray.size(); i++) {
			map.put(StudentManager.studentArray.get(i), scoreList.get(i));
			System.out.println(StudentManager.studentArray.get(i) + " " + StudentManager.studentArray.get(i).getStudentName());
		}
	}

	private void printAll() {
		System.out.println("전체출력");

	}

	private void search() {
		System.out.println("계속 검색하시겠습니까?(y/n)");

	}

	private void print() {
		System.out.println("반별점수");

	}
}
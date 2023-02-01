package b1331p2;

import java.util.Scanner;

public abstract class Grade {
	
	String subjectName;
	int midScore;
	int endScore;
	int actScore;
	int totalScore;
	String school;
	Scanner sc = new Scanner(System.in);
	
	
	public Grade (String school) {
		this.school = school; 
	}
	
	
	
	public abstract void addGrade();
	
	public void printAll() {
		System.out.println("---------------");
		System.out.println(school+ " 성적입니다.");
		System.out.println("---------------");
		System.out.println("과목명:"+subjectName);
		System.out.println("시험: 중간고사("+midScore+"), 기말고사("+endScore+"), 수행평가("+actScore+")");
		System.out.println("점수: "+totalScore);
	}
	
}

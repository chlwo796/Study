package b1331p2;

public class Middle extends Grade {	
	int attendScore;
	int volunteerScore;
	String teacher;
	
	public Middle() {
		super("중학교");
	}

	public Middle(String school) {
		super(school);
	}	
	
	@Override
	public void addGrade() {
		System.out.print("과목명:");
		subjectName = sc.nextLine();
		System.out.print("담당교사:");
		teacher = sc.nextLine();
		System.out.print("중간고사:");
		midScore =Integer.parseInt(sc.nextLine()) ;
		System.out.print("기말고사:");
		endScore =Integer.parseInt(sc.nextLine()) ;
		System.out.print("수행평가:");
		actScore =Integer.parseInt(sc.nextLine()) ;
		System.out.print("출석점수:");
		attendScore =Integer.parseInt(sc.nextLine()) ;
		System.out.print("봉사점수:");
		volunteerScore =Integer.parseInt(sc.nextLine()) ;
		totalScore = midScore + endScore + actScore +attendScore + volunteerScore; 
	}
	
	@Override
	public void printAll() {
		System.out.println("---------------");
		System.out.println(school+ " 성적입니다.");
		System.out.println("---------------");
		System.out.println("과목명:"+subjectName);
		System.out.println("시험: 중간고사("+midScore+"), 기말고사("+endScore+"), 수행평가("+actScore+"), 출석점수("+attendScore+"), 봉사점수("+volunteerScore+")");
		System.out.println("점수: "+totalScore);
	}
}

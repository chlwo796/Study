package b1331p2;

public class Element extends Grade {
	
	public Element() {
		super("초등학교");
	}
	public void addGrade() {
		System.out.print("과목명:");
		subjectName = sc.nextLine();
		System.out.print("중간고사:");
		midScore =Integer.parseInt(sc.nextLine()) ;
		System.out.print("기말고사:");
		endScore =Integer.parseInt(sc.nextLine()) ;
		System.out.print("수행평가:");
		actScore =Integer.parseInt(sc.nextLine()) ;
		totalScore = midScore + endScore + actScore; 
	}
}

package b1331p2;

public class Middle extends Grade {	
	int attendScore;
	int volunteerScore;
	String teacher;
	
	public Middle() {
		super("���б�");
	}

	public Middle(String school) {
		super(school);
	}	
	
	@Override
	public void addGrade() {
		System.out.print("�����:");
		subjectName = sc.nextLine();
		System.out.print("��米��:");
		teacher = sc.nextLine();
		System.out.print("�߰����:");
		midScore =Integer.parseInt(sc.nextLine()) ;
		System.out.print("�⸻���:");
		endScore =Integer.parseInt(sc.nextLine()) ;
		System.out.print("������:");
		actScore =Integer.parseInt(sc.nextLine()) ;
		System.out.print("�⼮����:");
		attendScore =Integer.parseInt(sc.nextLine()) ;
		System.out.print("��������:");
		volunteerScore =Integer.parseInt(sc.nextLine()) ;
		totalScore = midScore + endScore + actScore +attendScore + volunteerScore; 
	}
	
	@Override
	public void printAll() {
		System.out.println("---------------");
		System.out.println(school+ " �����Դϴ�.");
		System.out.println("---------------");
		System.out.println("�����:"+subjectName);
		System.out.println("����: �߰����("+midScore+"), �⸻���("+endScore+"), ������("+actScore+"), �⼮����("+attendScore+"), ��������("+volunteerScore+")");
		System.out.println("����: "+totalScore);
	}
}

package ch06.day01;

public class ClassEx02 {

	public static void main(String[] args) {
//		constructor, overloading
		Student st = new Student();
		Student st1 = new Student("ȫ�浿");
		Student st2 = new Student("010-1234-5678",100);
		Student st3 = new Student("ȫ�浿", 90);	// st2�� st3�� ������ Ÿ���� ����.
		Student st4 = new Student(85, "010-7894-5612");
		Student st5 = new Student("ȫ�浿");
		Student st6 = new Student("010-555-6666");	// String name ������ �Էµȴ�.
		
		System.out.println(st.getName() + "\t" + st.getPhone() + "\t" + st.getScores());
		System.out.println(st1.getName() + "\t" + st1.getPhone() + "\t" + st1.getScores());
		System.out.println(st2.getName() + "\t" + st2.getPhone() + "\t" + st2.getScores());
		System.out.println(st3.getName() + "\t" + st3.getPhone() + "\t" + st3.getScores());
		System.out.println(st4.getName() + "\t" + st4.getPhone() + "\t" + st4.getScores());
		System.out.println(st5.getName() + "\t" + st5.getPhone() + "\t" + st5.getScores());
	}

}
class Student{
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getScores() {
		return scores;
	}
	public void setScores(int scores) {
		this.scores = scores;
	}
	String phone;
	int scores;
	
	public Student() {
		System.out.println("Student class�� �⺻�����ںκ�");
	}
	public Student(String name) {
		this.name = name;
	}
	public Student(String phone, int scores) {
		this.phone = phone;
		this.scores = scores;
	}
//	public Student(String name, int scores) {	// ������Ÿ���� ����ȴ�. �����߻�
//		this.name = name;						// �����ε��� �⺻ = ���� �ٸ� ������Ÿ��
//		this.scores = scores;					// ()�ȿ� ������ Ÿ���� ������ �ٸ� ��� �ٸ� ������Ÿ���̴�.
//	}
	public Student(int scores, String phone) {
		this.scores = scores;
		this.phone = phone;
	}
	
}
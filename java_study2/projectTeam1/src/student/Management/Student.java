package student.Management;

public class Student {
	// �л� ���� �ʵ弳�� Ŭ����

	public String studentName; // �л� �̸�
	public String phoneNum; // ��ȭ��ȣ
	public String className; // ��
	public String subjectName; // �����

	public Student(String studentName, String phoneNum, String className, String subjectName) {
		// super();
		this.studentName = studentName;
		this.phoneNum = phoneNum;
		this.className = className;
		this.subjectName = subjectName;
	}

	// ���ͼ���
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

}
package student.Management;

public class Lecture {
	// ���� ���� �ʵ弳�� Ŭ����

	private String lecture; // ���� �̸�
	private String teacherName; // ������ �̸�
	private int tuition; // ������

	public Lecture(String lecture, String teacherName, int tuition) {
		super();
		this.lecture = lecture;
		this.teacherName = teacherName;
		this.tuition = tuition;
	}

	public String getLecture() {
		return lecture;
	}

	public void setLecture(String lecture) {
		this.lecture = lecture;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getTuition() {
		return tuition;
	}

	public void setTuition(int tuition) {
		this.tuition = tuition;
	}
}
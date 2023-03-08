package tempMemo;

public class School {
	private String schoolName;
	private int grade;

	public School(String schoolName, int grade) {
		super();
		this.schoolName = schoolName;
		this.grade = grade;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return grade + " grade in " + schoolName + "School";
	}
}

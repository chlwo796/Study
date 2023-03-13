package tempMemo;

public class School {
	private String schoolName;
	private int grade;
	private String studentName;
	private String location;

	public School(String schoolName) {
		this(schoolName, "¼­¿ï", "È«±æµ¿");
	}

	public School(String schoolName, String location) {
		this(schoolName, location, "È«±æµ¿");
	}

	public School(String schoolName, String location, String studentName) {
		this.schoolName = schoolName;
		this.location = location;
		this.studentName = studentName;
	}

	public School(String schoolName, int grade) {
		super();
		this.schoolName = schoolName;
		this.grade = grade;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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
		return schoolName + " " + location + " " + studentName;
	}
}

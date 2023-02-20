package student.Management;

import java.util.ArrayList;
import java.util.List;

public class Data {
	
	List<Student> studentList = new ArrayList<Student>();
	List<LectureData> list = new ArrayList<LectureData>();
	List<Score> scoreList = new ArrayList<Score>();
	
	public List<Score> getScoreList() {
		// scoreList.add() ¾îÂ¼±¸
		return scoreList;
	}

	public List<Student> getStudentList() {
		// studentList.add() ¾îÂ¼±¸
		return studentList;
	}

	public List<LectureData> getList() {
		// list.add() ¾îÂ¼±¸
		return list;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public void setList(List<LectureData> list) {
		this.list = list;
	}

	public void setScoreList(List<Score> scoreList) {
		this.scoreList = scoreList;
	}
}
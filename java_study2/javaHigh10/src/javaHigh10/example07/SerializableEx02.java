package javaHigh10.example07;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializableEx02 {
	public static void main(String[] args) throws IOException {
		// Student ��ü�� �ڷḦ �־ ����û�� ������

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/JHC/studentList.dat"));
		List<Student> studentList = new ArrayList<Student>();

		studentList.add(new Student("ȫ�浿1", 100, true));
		studentList.add(new Student("ȫ�浿2", 80, false));
		studentList.add(new Student("ȫ�浿3", 90, true));
		studentList.add(new Student("ȫ�浿4", 70, false));
		studentList.add(new Student("ȫ�浿5", 90, true));
		studentList.add(new Student("ȫ�浿6", 85, false));

		oos.writeObject(studentList);

		oos.flush();
		oos.close();
	}
}
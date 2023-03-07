package javaHigh10.example07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class School {
	// 교육청 학교에서 성적을 네트워크로 주면 입력받아서 가지고 있어야함
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/JHC/studentList.dat"));
		List<Student> list = (List<Student>) ois.readObject();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName() + list.get(i).getScore() + list.get(i).isSex());
		}
		ois.close();
	}
}
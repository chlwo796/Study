package javaHigh10.example07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class School {
	// ����û �б����� ������ ��Ʈ��ũ�� �ָ� �Է¹޾Ƽ� ������ �־����
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/JHC/studentList.dat"));
		List<Student> list = (List<Student>) ois.readObject();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName() + list.get(i).getScore() + list.get(i).isSex());
		}
		ois.close();
	}
}
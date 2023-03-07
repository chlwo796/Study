package javaHigh10.example07;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializableEx02 {
	public static void main(String[] args) throws IOException {
		// Student °´Ã¼¿¡ ÀÚ·á¸¦ ³Ö¾î¼­ ±³À°Ã»¿¡ º¸³½´Ù

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/JHC/studentList.dat"));
		List<Student> studentList = new ArrayList<Student>();

		studentList.add(new Student("È«±æµ¿1", 100, true));
		studentList.add(new Student("È«±æµ¿2", 80, false));
		studentList.add(new Student("È«±æµ¿3", 90, true));
		studentList.add(new Student("È«±æµ¿4", 70, false));
		studentList.add(new Student("È«±æµ¿5", 90, true));
		studentList.add(new Student("È«±æµ¿6", 85, false));

		oos.writeObject(studentList);

		oos.flush();
		oos.close();
	}
}
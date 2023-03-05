package javaChap18.example08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ObjectInputOutputStreamExample {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("C:/JHC/object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		Member member1 = new Member("fail", "¥‹«≥¿Ã");
		Product product1 = new Product("≥Î∆Æ∫œ", 1500000);
		int[] intArray1 = { 1, 2, 3 };

		oos.writeObject(member1);
		oos.writeObject(product1);
		oos.writeObject(intArray1);
		oos.flush();
		oos.close();
		fos.close();

		FileInputStream fis = new FileInputStream("C:/JHC/object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Member member2 = (Member) ois.readObject();
		Product product2 = (Product) ois.readObject();
		int[] intArray2 = (int[]) ois.readObject();

		ois.close();
		fis.close();

		System.out.println(member2);
		System.out.println(product2);
		System.out.println(Arrays.toString(intArray2));

	}
}
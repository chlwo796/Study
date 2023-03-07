package javaHigh10.example07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableEx01 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("C:/JHC/memberObject.dat");

		ObjectOutputStream oos = new ObjectOutputStream(fos);

		Member m1 = new Member("fail", "´ÜÇ³ÀÌ");
		Product p1 = new Product("³ëÆ®ºÏ", 1500000);
		int[] array1 = { 1, 2, 3, 4, 5 };
		// Á÷·ÄÈ­
		oos.writeObject(m1);
		oos.writeObject(p1);
		oos.writeObject(array1);

		oos.flush();
		oos.close();
		fos.close();

		FileInputStream fis = new FileInputStream("C:/JHC/memberObject.dat");

		ObjectInputStream ois = new ObjectInputStream(fis);

		Member m2 = (Member) ois.readObject();
		Product p2 = (Product) ois.readObject();
		int[] array2 = (int[]) ois.readObject();
		
		System.out.println(m2);
		System.out.println(p2);
		for (int number : array2) {
			System.out.print(number);
		}
	}
}
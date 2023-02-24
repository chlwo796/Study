package javaHigh06.example09;

public class ReflectionEx {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		Class c1 = Car.class;
		System.out.println(c1);

		Class c2 = Class.forName("javaHigh06.example09.Car");

		System.out.println(c2);
		System.out.println(c2.getDeclaredConstructors());
		System.out.println(c2.getDeclaredFields());
		System.out.println(c2.getDeclaredField("color"));
		// 집에서 다시 해보자
		Class c3 = Car.class;
		String photo1path = c3.getResource("1.jpg").getPath();
		String photo2path = c3.getResource("1.jpg").getPath();
		
		System.out.println(photo1path);
		System.out.println(photo2path);
		
		
	}
}
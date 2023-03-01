package javaChap13.example03;

public class GenericExample {
	public static void main(String[] args) {
		Box<Integer> box1 = boxing(100);
		int intValue = box1.getT();
		System.out.println(intValue);
		
		Box<String> box2 = boxing("ȫ�浿");
		String strValue = box2.getT();
		System.out.println(strValue);
	}

	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<T>();
		box.setT(t);
		return box;
	}
}

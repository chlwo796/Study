package javaChap12.example09;

public class GetResourceExample {
	public static void main(String[] args) {
		Class clazz = Car2.class;
		
		String photo1Path = clazz.getResource("1.jpg").getPath();
		String photo2Path = clazz.getResource("images/2.jpg").getPath();
		// ������ �� �ڵ����� bin���� �ҽ� ����
		System.out.println(photo1Path);
		System.out.println(photo2Path);
	}
}

class Car2 {

}

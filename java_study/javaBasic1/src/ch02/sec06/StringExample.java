package ch02.sec06;

public class StringExample {

	public static void main(String[] args) {
		// String type
		String name = "����ȯ";
		String job = "���";
		
		System.out.println(name);
		System.out.println(job);
		
		String java = "���� \"�ڹ�\"�� ���ϴ�.";	// \�ٷ� �� ���ڸ� ���ڷ�����Ѵ�.
		System.out.println(java);
		
		String nameTab = "��\t��\tȯ";
		System.out.println(nameTab);	// \t = ��½� Tab��ŭ ���.
		
		String nameLine = "��\n��\nȯ";	// \n = ��½� �ٹٲ�
		System.out.println(nameLine);

	}

}

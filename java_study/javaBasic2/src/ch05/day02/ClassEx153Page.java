package ch05.day02;

public class ClassEx153Page {

	public static void main(String[] args) {
//		���� 153������
		
		String name = "ȫ�浿�̼�������ȯ";
		String name1 = "ȫ�浿";
		
		String name2 = new String("ȫ�浿");
		String name3 = new String("ȫ�浿");
		
		char c0 = name.charAt(6);
		System.out.println(c0);
		
		int length = name.length();
		System.out.println("���̴� " + length);
		
		String changeword = name.replace("����ȯ", "�����̸�");
		System.out.println(changeword);
		
		String subString = name.substring(1, 8);
		System.out.println(subString);
		
		int index = name.indexOf("��");
		System.out.println(index);		
//		������ -1 ���, ���ǽ����� ���ڿ� ã�� ����.
		
		boolean result = name.contains("�浿");
		System.out.println(result);
		
	}

}

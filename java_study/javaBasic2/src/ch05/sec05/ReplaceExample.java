package ch05.sec05;

public class ReplaceExample {

	public static void main(String[] args) {
//		��ü�ϱ� = .replace("a", "b") a->b
		
		String A = "����ȯ";
		String newA = A.replace('ȯ', '��');	// A�� �����ϴ� ���� �ƴ� ���ο� String��ü�� ����
		
		System.out.println(A);
		System.out.println(newA);
		
		System.out.println(A==newA);		// ���ο� ��ü�� �����Ȱ��� Ȯ��.
		System.out.println(!A.equals(newA));	// ���ڿ��� �ٸ��� Ȯ��

	}

}

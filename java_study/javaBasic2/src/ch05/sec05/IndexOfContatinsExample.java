package ch05.sec05;

public class IndexOfContatinsExample {

	public static void main(String[] args) {
//		���ڿ�ã�� = .indexOf(), .contains()
//		.indexOf() = ���ԵǾ� ������ �ش� ��ġ, �ش� ���ڰ� ���ԵǾ� ���� ������ -1�� return
//		.contains() = ���ԵǾ� ������ true, �׷��� ������ false�� return
		
		String strA = "�ڹ� ���α׷���";
		
		int indexA = strA.indexOf("���α׷���");
		System.out.println(indexA);
		
		String substringA = strA.substring(indexA);
		System.out.println(substringA);
		
		int indexB = strA.indexOf("�ڹ�");
		if(indexB != -1) {
			System.out.println("�ڹٿ� ���õ� å�Դϴ�.");
		}else {
			System.out.println("�ڹٿ� ���õ� å�� �ƴմϴ�.");
		}
		
		boolean x = strA.contains("�ڹ�");
		
		if(x) {
			System.out.println("�ڹٿ� ���õ� å�Դϴ�.");
		}else {
			System.out.println("�ڹٿ� ���õ� å�� �ƴմϴ�.");
		}
		
//		�� ���� ��� �� ���� ����� ����غ���.
	}

}

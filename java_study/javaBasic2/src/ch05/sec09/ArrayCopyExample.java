package ch05.sec09;

public class ArrayCopyExample {

	public static void main(String[] args) {

//		System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
//		System.arraycopy(oldArray, beginningIndex, newArray, beginningIndex, oldArray.length);
		
		String[] oldArray = {"�ڹ�", "������", "����"};
		String[] newArray = new String[6];
		
		System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
//		oldArray[0]���� oldArray.length��ŭ newArray[0]���� ���� �����Ѵ�.
		
		for(int i = 0;i<newArray.length;i++) {
			System.out.println(newArray[i] + "\t");	// ��� �� Ȯ��
		}
	}

}

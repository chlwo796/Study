package ch05.sec09;

public class ArrayCopyExample {

	public static void main(String[] args) {

//		System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
//		System.arraycopy(oldArray, beginningIndex, newArray, beginningIndex, oldArray.length);
		
		String[] oldArray = {"자바", "뮤지컬", "음악"};
		String[] newArray = new String[6];
		
		System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
//		oldArray[0]부터 oldArray.length만큼 newArray[0]부터 값을 복사한다.
		
		for(int i = 0;i<newArray.length;i++) {
			System.out.println(newArray[i] + "\t");	// 출력 후 확인
		}
	}

}

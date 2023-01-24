package ch05.sec09;

public class ArrayCopyByForExample {

	public static void main(String[] args) {
//		배열복사
		int[] oldArray = {1, 5, 7};
		int[] newArray = new int[5];
		
		for(int i = 0; i<oldArray.length;i++) {
			newArray[i] = oldArray[i];
	
		}
		for(int i = 0; i<newArray.length;i++) {
			System.out.print(newArray[i] + "\t");	// oldArray의 길이만큼 같은 배열의 인덱스로 배열복사. 이 후 빈자리는 초기값형성
		}
		
	}

}

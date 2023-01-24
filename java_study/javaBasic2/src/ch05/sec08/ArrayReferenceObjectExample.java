package ch05.sec08;

public class ArrayReferenceObjectExample {

	public static void main(String[] args) {
//		참조배열
		
		String[] strArray = new String[3];
		
		strArray[0] = "자바";
		strArray[1] = "자바";
		strArray[2] = new String("java");	// stack이 아닌 heap의 주소를 참조함
		
		System.out.println(strArray[0] == strArray[1]);
		System.out.println(strArray[1] == strArray[2]);		// strArray[2]는 새로운 객체를 참조하는데 그 값이 java일 뿐이다. 그래서 false
		System.out.println(strArray[0].equals(strArray[2]));
		
		System.out.println(strArray.length);
		System.out.println(strArray[2]);
		
		System.out.println(strArray);
		
	}

}

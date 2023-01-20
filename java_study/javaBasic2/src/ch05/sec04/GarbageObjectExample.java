package ch05.sec04;

public class GarbageObjectExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String hobby = "취미";
		System.out.println(hobby);
		hobby = "여행";
		System.out.println(hobby);
		hobby = null;
		System.out.println(hobby);
		
		String car1 = "자동차";
		String car2 = car1;	// 2가 1을 참조.
		System.out.println(car1 + " " +car2);	//2가 1을 참조했을때 출력값
		
		car1 = null;	// car1에 null값을 대입
		
		System.out.println(car1 + " " +car2);	// 둘다 바뀌지 않는다.

	}

}

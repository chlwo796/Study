package javaBasic5.ex18;

public class ShopServiceMain {

	public static void main(String[] args) {
//		확인문제 18번
		ShopService obj1 = ShopService.getInstance();	// 클래스명.메소드명 = static 유추
		ShopService obj2 = ShopService.getInstance();
		
		if(obj1 == obj2) {
			System.out.println("같은 ShopService 객체입니다.");
		}else {
			System.out.println("다른 ShopService 객체입니다.");
		}

	}

}

package javaBasic5.ex18;

class ShopService {
//	확인문제 18번
	
//	싱글톤
//	1. private field 초기값 new 참조변수
//	2. public method return 참조변수
	private static ShopService shopService = new ShopService();

	private ShopService() {
	
	}

	public static ShopService getInstance() {
		return shopService;
	}

}
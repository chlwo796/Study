package javaBasic5.ex18;

class ShopService {
//	Ȯ�ι��� 18��
	
//	�̱���
//	1. private field �ʱⰪ new ��������
//	2. public method return ��������
	private static ShopService shopService = new ShopService();

	private ShopService() {
	
	}

	public static ShopService getInstance() {
		return shopService;
	}

}
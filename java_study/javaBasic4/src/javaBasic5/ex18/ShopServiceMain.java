package javaBasic5.ex18;

public class ShopServiceMain {

	public static void main(String[] args) {
//		Ȯ�ι��� 18��
		ShopService obj1 = ShopService.getInstance();	// Ŭ������.�޼ҵ�� = static ����
		ShopService obj2 = ShopService.getInstance();
		
		if(obj1 == obj2) {
			System.out.println("���� ShopService ��ü�Դϴ�.");
		}else {
			System.out.println("�ٸ� ShopService ��ü�Դϴ�.");
		}

	}

}

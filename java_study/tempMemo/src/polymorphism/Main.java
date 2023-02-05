package polymorphism;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car();

		for (int i = 0; i < 5; i++) {
			int problemLocation = car.run();
			switch (problemLocation) {
			case 1:
				System.out.println("�տ��� HankookTire�� ��ü");
				car.tire1 = new HankookTire("�տ���", 16);
				break;
			case 2:
				System.out.println("�տ����� KumhoTire�� ��ü");
				car.tire2 = new KumhoTire("�տ�����", 20);
				break;
			case 3:
				System.out.println("�ڿ��� HankookTire�� ��ü");
				car.tire3 = new HankookTire("�ڿ���", 15);
				break;
			case 4:
				System.out.println("�ڿ����� KumhoTire�� ��ü");
				car.tire4 = new KumhoTire("�ڿ�����", 17);
				break;
			}
		}
	}

}

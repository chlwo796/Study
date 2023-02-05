package polymorphism;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car();

		for (int i = 0; i < 5; i++) {
			int problemLocation = car.run();
			switch (problemLocation) {
			case 1:
				System.out.println("앞왼쪽 HankookTire로 교체");
				car.tire1 = new HankookTire("앞왼쪽", 16);
				break;
			case 2:
				System.out.println("앞오른쪽 KumhoTire로 교체");
				car.tire2 = new KumhoTire("앞오른쪽", 20);
				break;
			case 3:
				System.out.println("뒤왼쪽 HankookTire로 교체");
				car.tire3 = new HankookTire("뒤왼쪽", 15);
				break;
			case 4:
				System.out.println("뒤오른쪽 KumhoTire로 교체");
				car.tire4 = new KumhoTire("뒤오른쪽", 17);
				break;
			}
		}
	}

}

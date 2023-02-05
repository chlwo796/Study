package polymorphism;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car();

		for (int i = 0; i < 5; i++) {
			int problemLocation = car.run();
			switch (problemLocation) {
			case 1:
				System.out.println("????? HankookTire?? ???");
				car.tire1 = new HankookTire("?????", 16);
				break;
			case 2:
				System.out.println("??????? KumhoTire?? ???");
				car.tire2 = new KumhoTire("???????", 20);
				break;
			case 3:
				System.out.println("????? HankookTire?? ???");
				car.tire3 = new HankookTire("?????", 15);
				break;
			case 4:
				System.out.println("??????? KumhoTire?? ???");
				car.tire4 = new KumhoTire("???????", 17);
				break;
			}
		}
	}

}

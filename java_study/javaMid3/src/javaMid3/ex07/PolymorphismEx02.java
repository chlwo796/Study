package javaMid3.ex07;

public class PolymorphismEx02 {

	public static void main(String[] args) {
		Car car = new Car();
		car.tire = new Tire();	// car��� ����(main���� ��ü����)�� tire��� ������ ��´�.
//		tire ������ Car class���� field�� ����Ǿ���. �� �ּҸ� TireŬ������ �ּҷ� �Ѵ�.
//		class field�� ����� �θ�üŸ���� ������ �� Ŭ������ �ּҸ� �ִ� ����(�ּҿ� ���� Ŭ������ �޼ҵ带 ȣ���Ѵ�)
		car.run();
		
		car.tire = new HankookTire();
		car.run();
		
		car.tire = new KumhoTire();
		car.run();
		
	}
}

package javaChap13.example02;

public class GenericExample01 {
	public static void main(String[] args) {
		Product<Tv, String> product1 = new Product<Tv, String>();
		product1.setKind(new Tv());
		product1.setModel("����ƮƼ��");

		Tv tv = product1.getKind();
		String tvModel = product1.getModel();

		System.out.println(tv);
		System.out.println(tvModel);

		Product<Car, String> product2 = new Product<Car, String>();
		product2.setKind(new Car());
		product2.setModel("�׽���");

		Car car = product2.getKind();
		String carModel = product2.getModel();
		System.out.println(car);
		System.out.println(carModel);
	}
}

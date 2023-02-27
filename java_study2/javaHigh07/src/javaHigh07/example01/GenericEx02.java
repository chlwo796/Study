package javaHigh07.example01;

public class GenericEx02 {
	public static void main(String[] args) {
		Product<Tv, String> product1 = new Product<Tv, String>();
		product1.setKind(new Tv());
		Tv tv1 = product1.getKind();
		System.out.println(tv1); // tv1의 주소 출력
		product1.setModel("스마트tv");
		String str1 = product1.getModel();
		System.out.println(str1);
		
		Product<Tv, Integer> product2 = new Product<Tv, Integer>();
		product2.setKind(new Tv());
		product2.setModel(5000000);
		System.out.println(product2.getKind());
		System.out.println(product2.getModel());
		if(product2.getKind().toString().equals("TV") && product2.getModel()>=5000000) {
			System.out.println("차라리 " + new Car() +"를 사지!!!");
		}
		Product<Integer, Car> product3 = new Product<Integer, Car>();
		product3.setKind(10000000);
		product3.setModel(new Car());
		System.out.println(product3.getModel());
		System.out.println(product3.getKind());
		if(product3.getKind()>=10000000) {
			System.out.println("차라리 " + new Tv() + "를 사지 !!");
		}
		
	}
}

class Product<K, M> {
	private K kind;
	private M model;
	public K getKind() {
		return kind;
	}
	public void setKind(K kind) {
		this.kind = kind;
	}
	public M getModel() {
		return model;
	}
	public void setModel(M model) {
		this.model = model;
	}
}

class Tv{
@Override
public String toString() {
	// TODO Auto-generated method stub
	return "TV";
}
}

class Car{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "자동차";
	}
}

package javaHigh07.exercise02;

public class ContainerExample {
	public static void main(String[] args) {
		Container<String, String> container1 = new Container<String, String>();
		container1.setKM("최재환", "도적");
		String name1 = container1.getK();
		String job = container1.getM();
		System.out.println(name1);
		System.out.println(job);
		Container<String, Integer> container2 = new Container<String, Integer>();
		container2.setKM("홍길동", 35);
		String name2 = container2.getK();
		int value2 = container2.getM();
		System.out.println(name2);
		System.out.println(value2);
	}
}

class Container<K, M> {
	public K k;
	public M m;

	public M getM() {
		return m;
	}

	public K getK() {
		return k;
	}

	public void setKM(K k, M m) {
		this.m = m;
		this.k = k;
	}

	public Container(K k, M m) {
		super();
		this.k = k;
		this.m = m;
	}

	public Container() {
		// TODO Auto-generated constructor stub
	}

}

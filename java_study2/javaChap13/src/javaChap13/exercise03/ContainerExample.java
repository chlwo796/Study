package javaChap13.exercise03;

public class ContainerExample {
	public static void main(String[] args) {
		Container<String, String> container1 = new Container<String, String>();
		container1.set("È«±æµ¿", "µµÀû");
		String name1 = container1.getK();
		String job = container1.getV();

		Container<String, Integer> container2 = new Container<String, Integer>();
		container2.set("È«±æµ¿", 33);
		String name2 = container2.getK();
		int age = container2.getV();
	}
}

class Container<K, V> {
	private K k;
	private V v;

	public K getK() {
		return k;
	}

	public void set(K k, V v) {
		this.k = k;
		this.v = v;
	}

	public V getV() {
		return v;
	}

}
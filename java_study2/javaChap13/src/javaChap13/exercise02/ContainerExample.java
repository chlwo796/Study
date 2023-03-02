package javaChap13.exercise02;

public class ContainerExample {
	public static void main(String[] args) {
		Container<String> container1 = new Container<String>();
		container1.setT("ȫ�浿");
		String str = container1.getT();

		Container<Integer> container2 = new Container<Integer>();
		container2.setT(6);
		int value = container2.getT();
	}
}

class Container<T> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

}

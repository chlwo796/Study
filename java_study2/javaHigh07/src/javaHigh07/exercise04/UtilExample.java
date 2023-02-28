package javaHigh07.exercise04;

public class UtilExample {
	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<String, Integer>("È«±æµ¿", 35);
		Integer age = Util.getValue(pair, "È«±æµ¿");
		System.out.println(age);

		ChildPair<String, Integer> childPair = new ChildPair<String, Integer>("±èÀÚ¹Ù", 30);
		Integer childAge = Util.getValue(childPair, "±èÀÚ¹Ù");
		System.out.println(childAge);

//		OtherPair<String, Integer> otherPair = new OtherPair<String, Integer>("È«±æµ¿", 35);
//		Integer otherAge = Util.getValue(otherPair, "È«±æµ·");
//		System.out.println(otherAge);

	}
}

class Util<T extends Pair<String, Integer>> {
	
	public static <P extends Pair<K, V>, K, V> V getValue1(P p, K k) {
		return null;
	}

	public static Integer getValue(Pair<String, Integer> pair, String name) {
		if (pair.getKey().equals(name)) {
			return pair.getValue();
		}
		return 0;
	}
}

class Pair<K, V> {
	private K key;
	private V value;

	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
}

class ChildPair<K, V> extends Pair<K, V> {

	public ChildPair(K key, V value) {
		super(key, value);
		// TODO Auto-generated constructor stub
	}
}

class OtherPair<K, V> {
	private K key;
	private V value;

	public OtherPair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
}

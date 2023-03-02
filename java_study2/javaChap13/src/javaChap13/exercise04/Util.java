package javaChap13.exercise04;

public class Util {
	public static <P extends Pair<K, V>, K, V> V getValue(P p, K k) {
		if (p.getKey().equals(k)) {
			return p.getValue();
		}
		return null;
	}
}

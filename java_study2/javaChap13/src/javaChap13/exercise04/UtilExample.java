package javaChap13.exercise04;

public class UtilExample {
	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<String, Integer>("ȫ�浿", 35);
		Integer age = Util.getValue(pair, "ȫ�浿");
		System.out.println(age);
		
		ChildPair<String, Integer> childPair = new ChildPair<String, Integer>("�̼���", 50);
		Integer childAge = Util.getValue(childPair, "�̼���1");
		System.out.println(childAge);
		
//		OtherPair<String, Integer> otherPair = new OtherPair<String, Integer>("�̼���", 50);
//		Integer otherAge = Util.getValue(otherPair, "�̼���1");
//		System.out.println(otherAge);
	}
}

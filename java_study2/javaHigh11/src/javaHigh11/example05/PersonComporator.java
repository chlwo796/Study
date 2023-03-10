package javaHigh11.example05;

import java.util.Comparator;

public class PersonComporator implements Comparator<Person> {
	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		return Double.compare(o2.getPay(), o1.getPay());
	}
}
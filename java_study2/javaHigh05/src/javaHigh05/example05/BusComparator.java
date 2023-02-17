package javaHigh05.example05;

import java.util.Comparator;

public class BusComparator implements Comparator<Bus>{
	@Override
	public int compare(Bus o1, Bus o2) {
		// TODO Auto-generated method stub
		return o1.getStop().compareTo(o2.getStop());
	}

}

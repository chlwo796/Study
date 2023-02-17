package javaHigh05.example04;

import java.util.Comparator;

public class MovieComparator implements Comparator<Movie>{
	@Override
	public int compare(Movie o1, Movie o2) {
		// TODO Auto-generated method stub
		return o1.getMovieName().compareTo(o2.getMovieName());
	}

}

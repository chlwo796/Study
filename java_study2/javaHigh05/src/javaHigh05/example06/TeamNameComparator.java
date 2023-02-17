package javaHigh05.example06;

import java.util.Comparator;

public class TeamNameComparator implements Comparator<TeamName>{
@Override
public int compare(TeamName o1, TeamName o2) {
	// TODO Auto-generated method stub
	return o1.getTeamName().compareTo(o2.getTeamName());
}
}

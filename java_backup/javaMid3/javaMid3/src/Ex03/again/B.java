package Ex03.again;

public class B extends BB{
    int s=0;
	@Override
	public int sum() {
		for(int i=1; i<=100; i++) {
			s=s+i;
		}
		return s;
	}
	
}

package b1331p2;

public class High extends Middle {
	
	public High () {
		super("고등학교");
	}
	
	
	@Override
	public void printAll() {
		super.printAll();
		System.out.println("표준편차: 23.12");
	}
}

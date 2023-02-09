package javaMid10.toeic;

public class ToeicExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Toeic toeic = new Toeic();
		try {
			toeic.input();
		} catch (ScoreMinException e) {
			System.out.println(e.getMessage());
		} catch (ScoreMaxException e) {
			System.out.println(e.getMessage());
		}
	}

}

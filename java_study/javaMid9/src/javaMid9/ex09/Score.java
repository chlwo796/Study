package javaMid9.ex09;

public class Score {
	private static final int SCORE_MAX = 990;
	private static final int SCORE_MIN = 0;

	private int score;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void check() throws ScoreMaxException, ScoreMinException {
		if (score > SCORE_MAX) {
			throw new ScoreMaxException(SCORE_MAX + "�� �ʰ� �������� ���� �� �����ϴ�.");
		} else if (score < SCORE_MIN) {
			throw new ScoreMinException(SCORE_MIN + "�� �̸� �������� ���� �� �����ϴ�.");
		} else {
			System.out.println("����� ���� ������" + score + "�� �Դϴ�.");
			System.out.println("��� �Ͻðڽ��ϱ�?(y/n)");
		}
	}
}

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
			throw new ScoreMaxException(SCORE_MAX + "점 초과 토익점수 나올 수 없습니다.");
		} else if (score < SCORE_MIN) {
			throw new ScoreMinException(SCORE_MIN + "점 미만 토익점수 나올 수 없습니다.");
		} else {
			System.out.println("당신의 토익 점수는" + score + "점 입니다.");
			System.out.println("계속 하시겠습니까?(y/n)");
		}
	}
}

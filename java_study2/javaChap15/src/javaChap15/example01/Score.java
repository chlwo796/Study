package javaChap15.example01;

public class Score {
	private int scoreA;
	private int scoreB;
	Score score;

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public int getScoreA() {
		return scoreA;
	}

	public void setScoreA(int scoreA) {
		this.scoreA = scoreA;
	}

	public int getScoreB() {
		return scoreB;
	}

	public void setScoreB(int scoreB) {
		this.scoreB = scoreB;
	}

	public Score(int scoreA, int scoreB) {
		super();
		this.scoreA = scoreA;
		this.scoreB = scoreB;
	}

}

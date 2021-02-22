package model;
/*
 * Lớp lưu thông tin người chơi gồm Tên và Điểm
 */
public class Player implements IPlayer {
	private String name;
	private int score;

	public Player(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int compareTo(IPlayer o) {
		// TODO Auto-generated method stub
		if (this.getScore() > o.getScore()) {
			return -1;
		} else if (this.getScore() == o.getScore()) {
			return 0;
		}
		return 1;
	}

}

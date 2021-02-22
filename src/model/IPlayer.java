package model;

public interface IPlayer extends Comparable<IPlayer>{
	public String getName();

	public int getScore();

	public void setName(String name);

	public void setScore(int score);
}

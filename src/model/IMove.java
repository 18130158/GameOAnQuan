package model;

public interface IMove {
	public void move(int index, boolean direction, boolean turn);

	public void recursiveMove(int index, boolean direction, boolean turn);

}

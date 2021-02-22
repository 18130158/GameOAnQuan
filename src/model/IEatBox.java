package model;

public interface IEatBox {
	public void eat(int index, boolean direction, boolean turn);

	public void recursiveEat(int index, boolean direction, boolean turn);
}

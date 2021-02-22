package model;

import java.util.List;

import view.BoardView;

public interface Model_Interface {
	public boolean isValid(int index, boolean turn);

	public void move(int index, boolean direction, boolean turn);

	public void turnOver(boolean turn);

	public boolean checkBox(boolean turn);

	public void addChess(boolean turn);

	public boolean isOver();

	public void gameOver();

	public List<IBox> getListBox();

	public List<IPlayer> getListPlayer();

	public BoardView getView();
}

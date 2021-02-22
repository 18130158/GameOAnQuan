package AI;

import java.util.List;

import model.IBox;
import model.IPlayer;
import model.Model_Interface;
import view.BoardView;

public interface AI_Interface {
	public boolean isValid(int index, boolean turn);

	public void move(int index, boolean direction, boolean turn);

	public boolean checkBox(boolean turn);

	public void addChess(boolean turn);

	public boolean isOver();

	public void computerMove(boolean turn, int level);

	public List<IBox> getListBox();

	public List<IPlayer> getListPlayer();

}

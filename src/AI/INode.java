package AI;

import java.util.List;

public interface INode {

	public List<INode> getNeighbours(boolean turn);

	public AI_Interface getAI();

	public int getIndex();

	public boolean getDirection();

	public boolean getTurn();
}

package AI;

public interface IMove_AI {
	public void move(int index, boolean direction, boolean turn);

	public void recursiveMove(int index, boolean direction, boolean turn);
}

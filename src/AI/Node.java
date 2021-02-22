package AI;

import java.util.ArrayList;
import java.util.List;

import model.Model_Interface;

public class Node implements INode {
	private List<INode> neighbours;
	private AI_Interface ai;
	private int index;
	private boolean direction;
	private boolean turn;

	public Node(AI_Interface ai) {
		super();
		this.ai = ai;
		neighbours = new ArrayList<>();
	}

	public Node(AI_Interface ai, int index, boolean direction, boolean turn) {
		ai.move(index, direction, turn);
		this.ai = ai;
		this.index = index;
		this.direction = direction;
		this.turn = turn;
		this.neighbours = new ArrayList<>();
	}

	public void addNeighbours(INode neighbourNode) {
		this.neighbours.add(neighbourNode);
	}

	// Hàm tạo ra các nút con sau đó thêm các nút con đó vào danh sách neighbours và
	// in ra danh sách neighbours
	@Override
	public List<INode> getNeighbours(boolean turn) {
		if (ai.checkBox(turn)) {
			ai.addChess(turn);
		}
		if (turn) {
			for (int i = 1; i < 6; i++) {
				if (!ai.isOver() && ai.getListBox().get(i).getNumberStone() != 0) {
					Node node1 = new Node(new AI(ai), i, false, true);
					Node node2 = new Node(new AI(ai), i, true, true);
					addNeighbours(node1);
					addNeighbours(node2);
				}
			}
		} else {
			for (int i = 7; i < 12; i++) {
				if (!ai.isOver() && ai.getListBox().get(i).getNumberStone() != 0) {
					Node node1 = new Node(new AI(ai), i, false, false);
					Node node2 = new Node(new AI(ai), i, true, false);
					addNeighbours(node1);
					addNeighbours(node2);
				}
			}
		}
		return neighbours;
	}

	@Override
	public AI_Interface getAI() {
		return ai;
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public boolean getDirection() {
		return direction;
	}

	@Override
	public boolean getTurn() {
		return turn;
	}

}

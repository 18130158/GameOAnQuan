package AI;

import java.util.ArrayList;
import java.util.List;

import model.Box;
import model.IBox;
import model.IPlayer;
import model.Model_Interface;
import model.Player;

public class AI implements AI_Interface {
	private Model_Interface model;
	private IMove_AI move;
	private List<IBox> listBox = new ArrayList<>();
	private List<IPlayer> listPlayer = new ArrayList<>();
	private INode nodeResult;
	private int level;

	// Tạo đối tượng AI truyền vào thông tin là bàn cờ cũ
	// để tạo ra 1 bàn cờ riêng biệt để xử lý AI

	public AI(Model_Interface model) {
		this.model = model;
		for (IBox box : model.getListBox()) {
			IBox boxTemp = new Box(box.getIndex());
			boxTemp.setNumberStone(box.getNumberStone());
			listBox.add(boxTemp);
		}
		for (IPlayer player : model.getListPlayer()) {
			IPlayer playerTemp = new Player(player.getName(), player.getScore());
			listPlayer.add(playerTemp);
		}
		this.move = new Move_AI(this);
	}

	// Tạo ra đối tượng AI truyền vào thông tin là AI
	// để tạo đối tượng AI tương ứng để xử lý

	public AI(AI_Interface ai) {
		for (IBox box : ai.getListBox()) {
			IBox boxTemp = new Box(box.getIndex());
			boxTemp.setNumberStone(box.getNumberStone());
			listBox.add(boxTemp);
		}
		for (IPlayer player : ai.getListPlayer()) {
			IPlayer playerTemp = new Player(player.getName(), player.getScore());
			listPlayer.add(playerTemp);
		}
		this.move = new Move_AI(this);
	}

	// Kiểm tra tính hợp lệ của nước đi

	@Override
	public boolean isValid(int index, boolean turn) {
		// TODO Auto-generated method stub
		if (listBox.get(index).getNumberStone() == 0 || index == 0)
			return false;
		if (((turn == true) && (index > 0 && index < 6)) || ((turn == false) && (index > 6 && index < 12))) {
			return true;
		}
		return false;
	}

	// Di chuyển quân trên bàn cờ

	@Override
	public void move(int index, boolean direction, boolean turn) {
		// TODO Auto-generated method stub
		move.move(index, direction, turn);
	}
	// Hàm kiểm tra phần sân của người chơi tương ứng là còn dân hay không
	@Override
	public boolean checkBox(boolean turn) {
		// TODO Auto-generated method stub
		if (turn) {
			for (int i = 1; i < 6; i++) {
				if (listBox.get(i).getNumberStone() != 0)
					return false;
			}
		} else {
			for (int i = 7; i < 12; i++) {
				if (listBox.get(i).getNumberStone() != 0)
					return false;
			}
		}

		return true;
	}
	// Thêm dân vào phần sân của người chơi tương ứng
	@Override
	public void addChess(boolean turn) {
		// TODO Auto-generated method stub
		if (turn) {
			listPlayer.get(0).setScore(listPlayer.get(0).getScore() - 5);
			for (int i = 1; i < 6; i++) {
				listBox.get(i).setNumberStone(1);
			}
		} else {
			listPlayer.get(1).setScore(listPlayer.get(1).getScore() - 5);
			for (int i = 7; i < 12; i++) {
				listBox.get(i).setNumberStone(1);

			}
		}
	}
	//Kiểm tra Trò chơi có thể kết thúc hay chưa
	@Override
	public boolean isOver() {
		// TODO Auto-generated method stub
		return listBox.get(0).getNumberStone() == 0 && listBox.get(6).getNumberStone() == 0;
	}
	//Phương thức tính Hueristic của 1 Node
	public int heuristic(INode node) {
		return node.getAI().getListPlayer().get(0).getScore() - node.getAI().getListPlayer().get(1).getScore();
	}
	//Phương thứ Minimax nhập vào 1 node, độ sâu của thuật toán và lượt của người chơi
	//-Nếu là Máy thì sẽ chọn giá trị lớn nhất của node con
	//-Nếu là người chơi thì sẽ chọn giá trị nhỏ của node con
	//Giá trị dùng để xác định là heuristic của node có độ sâu là 0
	// hoặc bàn cờ có thể thể kết thúc và điểm của máy cao hơn người chơi
	public int minimax(INode node, int depth, boolean maximizingPlayer) {
		if (depth == 0 || (node.getAI().isOver() && checkScore(node) > 0)) {
			return heuristic(node);
		}
		if (maximizingPlayer) {
			int Mx = Integer.MIN_VALUE;
			for (INode n : node.getNeighbours(maximizingPlayer)) {
				Mx = Math.max(Mx, minimax(n, depth - 1, false));
			}
			return Mx;
		} else {
			int Mn = Integer.MAX_VALUE;
			for (INode n : node.getNeighbours(maximizingPlayer)) {
				Mn = Math.min(Mn, minimax(n, depth - 1, true));
			}
			return Mn;
		}

	}
	//Phương thứ Alpha-Beta nhập vào 1 node, độ sâu của thuật toán, 2 số a,b(chặn dưới và chặn trên) và lượt của người chơi
	// -Nếu là Máy thì sẽ chọn giá trị lớn nhất của node con, 
	//		nếu có node nào cho chặn dưới lớn hơn hoặc bằng chặn trên thì sẽ không xét node con của node đó
	// -Nếu là người chơi thì sẽ chọn giá trị nhỏ của node con,
	//		nếu có node nào cho chặn dưới lớn hơn hoặc bằng chặn trên thì sẽ không xét node con và node cạnh của node đó
	//Giá trị dùng để xác định là heuristic của node có độ sâu là 0
	// hoặc bàn cờ có thể thể kết thúc và điểm của máy cao hơn người chơi
	public int alphabeta(INode node, int depth, int a, int b, boolean maximizingPlayer) {
		if (depth == 0 || (node.getAI().isOver() && checkScore(node) > 0)) {
			return heuristic(node);
		}
		if (maximizingPlayer) {
			for (INode n : node.getNeighbours(maximizingPlayer)) {
				a = Math.max(a, alphabeta(n, depth - 1, a, b, false));
				if (a >= b)
					break;
			}
			return a;
		} else {
			for (INode n : node.getNeighbours(maximizingPlayer)) {
				b = Math.min(b, alphabeta(n, depth - 1, a, b, true));
				if (a >= b)
					break;
			}
			return b;
		}
	}
	//Phương thức thực hiện lượt di chuyển của máy
	@Override
	public void computerMove(boolean turn, int level) {
		this.level = level;
		Node node = new Node(this);
		int i = 0, max = Integer.MIN_VALUE;
		for (INode n : node.getNeighbours(turn)) {
			if (n.getAI().isOver() && heuristic(n) > 0) {
				nodeResult = n;
				break;
			} else {
//				i = minimax(n, this.level-1, !turn);
				i = alphabeta(n, this.level - 1, Integer.MIN_VALUE, Integer.MAX_VALUE, !turn);
				if (i > max) {
					max = i;
					this.nodeResult = n;
				}
			}
		}
		model.move(nodeResult.getIndex(), nodeResult.getDirection(), nodeResult.getTurn());

	}
	//Kiểm tra điềm của 2 người chơi trong node
	//Trả về giá trị là điểm người chơi 1 trừ điểm người chơi 2
	public int checkScore(INode node) {
		for (int i = 1; i < 6; i++) {
			int score = node.getAI().getListBox().get(i).getNumberStone();
			node.getAI().getListBox().get(i).setNumberStone(0);
			node.getAI().getListPlayer().get(0).setScore(node.getAI().getListPlayer().get(0).getScore() + score);

		}
		for (int i = 7; i < 12; i++) {
			int score = node.getAI().getListBox().get(i).getNumberStone();
			node.getAI().getListBox().get(i).setNumberStone(0);
			node.getAI().getListPlayer().get(1).setScore(node.getAI().getListPlayer().get(1).getScore() + score);
		}
		return node.getAI().getListPlayer().get(0).getScore() - node.getAI().getListPlayer().get(1).getScore();
	}

	@Override
	public List<IBox> getListBox() {
		// TODO Auto-generated method stub
		return listBox;
	}

	@Override
	public List<IPlayer> getListPlayer() {
		// TODO Auto-generated method stub
		return listPlayer;
	}

	public int getLevel() {
		return level;
	}
}

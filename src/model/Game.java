package model;

import java.util.ArrayList;
import java.util.List;

import view.BoardView;
import view.IHighScore;

public abstract class Game implements Model_Interface {
	protected BoardView view;
	protected List<IBox> listBox = new ArrayList<>();
	protected List<IPlayer> listPlayer = new ArrayList<>();
	protected IModel_HighScore highScore = new HighScoreModel();
	private IMove move;
	public final boolean TURNPLAYER_1 = true;
	public final boolean TURNPLAYER_2 = false;
	public final boolean DIRECTION_LEFT = false;
	public final boolean DIRECTION_RIGHT = true;

	public Game(BoardView view) {
		this.view = view;
		this.move = new Move(this);
		createBox();
	}

	public void createBox() {
		for (int i = 0; i < 12; i++) {
			IBox tempBox = new Box(i);
			listBox.add(tempBox);
		}

	}

	// -Hàm đánh giá xem 1 ô có chọn đúng và được phép di chuyển hay không
	// -Di chuyển:
	// +Lượt người chơi 1 chỉ được chọn từ ô 1 đến 5 và số dân trong ô phải khác 0
	// +Lượt người chơi 2 chỉ được chọn từ ô 7 đến 11 và số dân trong ô phải khác 0

	@Override
	public boolean isValid(int index, boolean turn) {
		// TODO Auto-generated method stub
		if (listBox.get(index).getNumberStone() == 0 || index == 0)
			return false;
		if (((turn == TURNPLAYER_1) && (index > 0 && index < 6))
				|| ((turn == TURNPLAYER_2) && (index > 6 && index < 12))) {
			return true;
		}
		return false;
	}

	// Hàm di chuyển 1 ô trên bàn cờ
	// Dùng thread để tạo luồng di chuyển, cho phép cập nhật ô khi chạy thuật toán
	// Nếu không có Thread thì view không thể cập nhật do hàm chạy trong
	// ActionPerformed
	@Override
	public void move(int index, boolean direction, boolean turn) {
		// TODO Auto-generated method stub
		if (isValid(index, turn)) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					move.move(index, direction, turn);
				}
			}).start();

		}
	}

	// Đổi lượt người chơi
	@Override
	public abstract void turnOver(boolean turn);

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
	// Cập nhật trong listBox và view

	@Override
	public void addChess(boolean turn) {
		// TODO Auto-generated method stub
		if (turn) {
			listPlayer.get(0).setScore(listPlayer.get(0).getScore() - 5);
			view.updateScore(listPlayer.get(0).getScore(), turn);
			for (int i = 1; i < 6; i++) {
				listBox.get(i).setNumberStone(1);
				view.updateStone(i, 1);
			}
		} else {
			listPlayer.get(1).setScore(listPlayer.get(1).getScore() - 5);
			view.updateScore(listPlayer.get(1).getScore(), turn);
			for (int i = 7; i < 12; i++) {
				listBox.get(i).setNumberStone(1);
				view.updateStone(i, 1);

			}
		}
	}

	//Kiểm tra Trò chơi có thể kết thúc hay chưa

	@Override
	public boolean isOver() {
		// TODO Auto-generated method stub
		return listBox.get(0).getNumberStone() == 0 && listBox.get(6).getNumberStone() == 0;
	}

	// Xử lý cập nhật điểm vào file HighScore.txt
	// Hiển thị JFrame gameOver

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		for (int i = 1; i < 6; i++) {
			int score = listBox.get(i).getNumberStone();
			listBox.get(i).setNumberStone(0);
			listPlayer.get(0).setScore(listPlayer.get(0).getScore() + score);

		}
		for (int i = 7; i < 12; i++) {
			int score = listBox.get(i).getNumberStone();
			listBox.get(i).setNumberStone(0);
			listPlayer.get(1).setScore(listPlayer.get(1).getScore() + score);
		}
		highScore.update(listPlayer);
		view.gameOver(listPlayer);
	}

	public List<IBox> getListBox() {
		return listBox;
	}

	public List<IPlayer> getListPlayer() {
		return listPlayer;
	}

	@Override
	public BoardView getView() {
		return view;
	}

}

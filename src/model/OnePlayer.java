package model;

import AI.AI;
import AI.AI_Interface;
import view.BoardView;

public class OnePlayer extends Game {
	private AI_Interface ai;
	private int level;

	public OnePlayer(String player_Name, BoardView view, int level) {
		super(view);
		this.listPlayer.add(new Player("Computer", 0));
		this.listPlayer.add(new Player(player_Name, 0));
		this.level = level;
	}

	// Hàm thay đổi lượt:
	// +Kiểm tra phần sân còn dân để di chuyển hay không
	// + Nếu không thì rải thêm dân
	// +Nếu là lượt của máy thì gọi đến Interface AI_Interface để tính toán
	@Override
	public void turnOver(boolean turn) {
		// TODO Auto-generated method stub
		if (turn == TURNPLAYER_1) {
			if (checkBox(TURNPLAYER_2)) {
				addChess(TURNPLAYER_2);
			}
			view.turnOver(TURNPLAYER_2);
			// them xu ly
		} else {
			if (checkBox(TURNPLAYER_1)) {
				addChess(TURNPLAYER_1);
			}
			view.turnOverComputer();
			ai = new AI(this);
			ai.computerMove(TURNPLAYER_1, level);
			// them xu ly

		}
	}

}

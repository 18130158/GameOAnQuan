package controller;

import model.Model_Interface;
import view.BoardView;
import view.View_Interface;

public class Controller implements Controller_Interface {

	private Model_Interface model;

	public Controller(Model_Interface model, BoardView view) {
		super();
		this.model = model;

	}

	// Hàm di chuyển 1 ô
	@Override
	public void move(int index, boolean direction, boolean turn) {
		// TODO Auto-generated method stub
		model.move(index, direction, turn);
	}

}

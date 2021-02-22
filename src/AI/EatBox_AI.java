package AI;

import model.Model_Interface;
import view.BoardView;

public class EatBox_AI implements IEatBox_AI {
	private AI_Interface ai;

	public EatBox_AI(AI_Interface ai) {
		this.ai = ai;
	}

	@Override
	public void eat(int index, boolean direction, boolean turn) {
		// TODO Auto-generated method stub
		recursiveEat(index, direction, turn);
	}

	@Override
	public void recursiveEat(int index, boolean direction, boolean turn) {
		// TODO Auto-generated method stub
		int i = turn ? 0 : 1;
		if (direction == false) {
			if ((index != 0 || index != 6) && ai.getListBox().get(index).getNumberStone() == 0) {
				if (index == 0)
					index = 12;
				index = index - 1;
				if (ai.getListBox().get(index).getNumberStone() != 0) {
					int soldier = ai.getListBox().get(index).getNumberStone();
					ai.getListBox().get(index).setNumberStone(0);
					ai.getListPlayer().get(i).setScore(soldier + ai.getListPlayer().get(i).getScore());

					if (index == 0) {
						index = 12;
					}

					if (ai.getListBox().get(index - 1).getNumberStone() == 0 && (index - 1 != 0 || index - 1 != 6)) {
						recursiveEat(index - 1, direction, turn);
					}
				}
			}
		} else {
			if ((index != 0 || index != 6) && ai.getListBox().get(index).getNumberStone() == 0) {
				if (index == 11) {
					index = -1;
				}
				index = index + 1;
				if (ai.getListBox().get(index).getNumberStone() != 0) {
					int soldier = ai.getListBox().get(index).getNumberStone();
					ai.getListBox().get(index).setNumberStone(0);
					ai.getListPlayer().get(i).setScore(soldier + ai.getListPlayer().get(i).getScore());

					if (index == 11) {
						index = -1;
					}
					if (ai.getListBox().get(index + 1).getNumberStone() == 0 && (index + 1 != 6 || index + 1 != 12)) {
						recursiveEat(index + 1, direction, turn);
					}
				}
			}
		}

	}
}

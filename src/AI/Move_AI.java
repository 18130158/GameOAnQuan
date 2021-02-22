package AI;

import model.EatBox;
import model.IEatBox;
import model.Model_Interface;

public class Move_AI implements IMove_AI {
	private IEatBox_AI eatBox;
	private AI_Interface ai;

	public Move_AI(AI_Interface ai) {
		this.ai = ai;
		this.eatBox = new EatBox_AI(ai);
	}

	@Override
	public void move(int index, boolean direction, boolean turn) {
		// TODO Auto-generated method stub
		if (index > 6 && index < 12) {
			direction = direction ? false : true;
		}
		recursiveMove(index, direction, turn);
	}

	@Override
	public void recursiveMove(int index, boolean direction, boolean turn) {
		// TODO Auto-generated method stub
		int numberStone = ai.getListBox().get(index).getNumberStone();
		ai.getListBox().get(index).setNumberStone(0);

		if (direction == false) {
			while (numberStone != 0) {
				if (index == 0) {
					index = 12;
				}
				index--;
				ai.getListBox().get(index).setNumberStone(ai.getListBox().get(index).getNumberStone() + 1);
				numberStone--;

				if (index == 0) {
					index = 12;
				}
				if (numberStone == 0) {
					if (index == 1 || index == 7 || (ai.getListBox().get(index - 1).getNumberStone() == 0
							&& ai.getListBox().get(index - 2).getNumberStone() == 0)) {

					} else if ((index - 1 != 0 || index - 1 != 6)
							&& ai.getListBox().get(index - 1).getNumberStone() == 0) {
						eatBox.eat(index - 1, direction, turn);
					} else if ((index - 1 != 0 || index - 1 != 6)
							&& ai.getListBox().get(index - 1).getNumberStone() != 0) {
						recursiveMove(index - 1, direction, turn);
					}
				}
			}
		} else {
			while (numberStone != 0) {
				if (index == 11) {
					index = -1;
				}
				index++;
				ai.getListBox().get(index).setNumberStone(ai.getListBox().get(index).getNumberStone() + 1);
				numberStone--;

				if (index == 11) {
					index = -1;
				}
				if (numberStone == 0) {
					int temp = (index == 10) ? 0 : index + 2;
					if ((index == 5 || index == -1) || (ai.getListBox().get(index + 1).getNumberStone() == 0
							&& ai.getListBox().get(temp).getNumberStone() == 0)) {

					} else if ((index + 1 != 0 || index + 1 != 6)
							&& ai.getListBox().get(index + 1).getNumberStone() == 0) {
						eatBox.eat(index + 1, direction, turn);
					} else if ((index + 1 != 0 || index + 1 != 6)
							&& ai.getListBox().get(index + 1).getNumberStone() != 0) {
						recursiveMove(index + 1, direction, turn);
					}
				}
			}
		}

	}
}

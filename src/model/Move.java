package model;

import view.BoardView;

public class Move implements IMove {
	private Model_Interface game;
	private IEatBox eatBox;
	private BoardView view;

	public Move(Model_Interface game) {
		this.game = game;
		this.view = game.getView();
		this.eatBox = new EatBox(game);
	}

	// -Phương thức di chuyển truyền vào Vị Trí ô được chọn, Hướng di chuyển và Lượt
	// của người chơi
	//
	// -Hàm xử lý di chuyển thực hiện cách di chuyển của người chơi 1 nên khi người
	// chơi 2 muốn di chuyển phải đổi lại hướng đi
	//
	// -Gọi đến hàm xử lý di chuyển
	@Override
	public void move(int index, boolean direction, boolean turn) {
		// TODO Auto-generated method stub
		if (index > 6 && index < 12) {
			direction = direction ? false : true;
		}
		recursiveMove(index, direction, turn);

	}

	// -Hàm xử lý cách di chuyển của người chơi 1 gồm di sang phải và di chuyển
	// sang trái( người chơi 2 cách di chuyển ngược với người chơi 1)
	// -Cách xử lý di chuyển:
	// 	+B1: Lấy số dân trong ô được chọn, cập nhật giá trị ô đó trên listBox và
	// 		trênview
	// 	+B2: Rải dân vào từng ô( 1 ô rải vào 1 dân), câp nhật lại số dân trong
	// 		listBox và trên view
	// 	+B3: Khi hết dân dùng để rải:
	// 		++ TH1: Nếu ô tiếp theo là ô Quan hoặc 2 ô tiếp theo không có dân thì dừng và đổi lượt
	// 		++ TH2: Nếu ô tiếp theo là không phải ô quan và ô đó không có dân thì ăn ô tiếp 
	//				theo(gọi đến interface IEatBox)
	//		++ TH3: Nếu ô tiếp theo có dân thì lấy ô đó đi tiếp

	@Override
	public void recursiveMove(int index, boolean direction, boolean turn) {
		// TODO Auto-generated method stub

		// Lấy số quân ở ô được chọn ra
		// Cập nhật số quân lại bằng 0

		int numberStone = game.getListBox().get(index).getNumberStone();
		game.getListBox().get(index).setNumberStone(0);

		// update trang thai tren BoardView

		try {
			view.draw(index, turn);
			view.updateRestStone(numberStone, turn);
			view.updateStone(index, game.getListBox().get(index).getNumberStone());
			Thread.sleep(500);
			view.reDraw(index);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Move A");
		}

		//

		// Xử lý theo hướng đi

		if (direction == false) {// Di chuyển sang trái
			while (numberStone != 0) {
				if (index == 0) {// Trường hợp đặt biệt, gán vị trí giả để xử lý
					index = 12;
				}
				// Vị trí ô hiện tại giảm 1 và số quân ở ô đó được cộng thêm 1
				// Số quân dùng để rải giảm đi 1
				index--;
				game.getListBox().get(index).setNumberStone(game.getListBox().get(index).getNumberStone() + 1);
				numberStone--;

				// update trang thai tren BoardView

				try {
					view.draw(index, turn);
					view.updateRestStone(numberStone, turn);
					view.updateStone(index, game.getListBox().get(index).getNumberStone());
					Thread.sleep(500);
					view.reDraw(index);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Move B");
				}

				//

				if (index == 0) {
					index = 12;
				}
				//
				if (numberStone == 0) {
						//TH1
					if (index == 1 || index == 7 || (game.getListBox().get(index - 1).getNumberStone() == 0
							&& game.getListBox().get(index - 2).getNumberStone() == 0)) {
						game.turnOver(turn);
					} 
						//TH2
					else if ((index - 1 != 0 || index - 1 != 6)
							&& game.getListBox().get(index - 1).getNumberStone() == 0) {
						eatBox.eat(index - 1, direction, turn);
					}	
						//TH3
					else if ((index - 1 != 0 || index - 1 != 6)
							&& game.getListBox().get(index - 1).getNumberStone() != 0) {
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
				game.getListBox().get(index).setNumberStone(game.getListBox().get(index).getNumberStone() + 1);
				numberStone--;

				// update trang thai tren BoardView

				try {
					view.draw(index, turn);
					view.updateRestStone(numberStone, turn);
					view.updateStone(index, game.getListBox().get(index).getNumberStone());
					Thread.sleep(500);
					view.reDraw(index);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Move C");
				}

				//

				if (index == 11) {
					index = -1;
				}
				if (numberStone == 0) {
					int temp = (index == 10) ? 0 : index + 2;
						//TH1
					if ((index == 5 || index == -1) || (game.getListBox().get(index + 1).getNumberStone() == 0
							&& game.getListBox().get(temp).getNumberStone() == 0)) {
						game.turnOver(turn);
					} 
						//TH2
					else if ((index + 1 != 0 || index + 1 != 6)
							&& game.getListBox().get(index + 1).getNumberStone() == 0) {
						eatBox.eat(index + 1, direction, turn);
					} 
						//TH3
					else if ((index + 1 != 0 || index + 1 != 6)
							&& game.getListBox().get(index + 1).getNumberStone() != 0) {
						recursiveMove(index + 1, direction, turn);
					}
				}
			}
		}

	}

}

package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighScoreModel implements IModel_HighScore {
	private List<IPlayer> list = new ArrayList<>();

	public HighScoreModel() {

	}

	// Hàm đọc dữ liệu từ file lưu dữ liệu sau đó trả về danh sách người chơi có
	// điểm cao được thêm trong file
	public List<IPlayer> readHighScore() {
		try {
			// Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
			File f = new File("HighScore.txt");
			FileReader fr = new FileReader(f);
			// Bước 2: Đọc dữ liệu
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				int index = line.indexOf(":");
				String name = line.substring(0, index);
				int score = Integer.parseInt(line.substring(index + 1));
				list.add(new Player(name, score));
			}
			// Bước 3: Đóng luồng
			fr.close();
			br.close();
			Collections.sort(list);

		} catch (Exception ex) {

		}
		return list;

	}

	// Ghi dữ liệu vào file
	public void writeHighScore() {
		try {
			Collections.sort(list);
			FileOutputStream fo = new FileOutputStream("HighScore.txt");
			PrintStream out = new PrintStream(fo);
			for (int i = 0; i < list.size(); i++) {
				out.println(list.get(i).getName() + ":" + list.get(i).getScore());
			}
			fo.close();
			out.close();
		} catch (Exception e) {
			System.out.println("Loi HighScoreController");
		}
	}

	// Cài đặt lại giá trị trong file điểm cao trở lại 0
	public void reset() {
		try {
			FileOutputStream fo = new FileOutputStream("HighScore.txt");
			PrintStream out = new PrintStream(fo);
			for (int i = 0; i < 10; i++) {
				out.println(" :0");
				list.remove(i);
				list.add(i, new Player("", 0));
			}
			fo.close();
			out.close();
		} catch (Exception e) {
			System.out.println("Loi HighScoreController");
		}
	}

	// Thêm điểm cao của người chơi vào file điểm cao
	@Override
	public void update(List<IPlayer> listPlayer) {
		// TODO Auto-generated method stub
		IPlayer player_1 = listPlayer.get(0);
		IPlayer player_2 = listPlayer.get(1);
		list = readHighScore();
		int size = list.size();
		if (player_1.getName() != "Computer") {
			for (int i = 0; i < size; i++) {
				if (player_1.getScore() > list.get(i).getScore()) {
					list.add(i, player_1);
					list.remove(list.size() - 1);
					i = size;
				}
			}
		}
		for (int i = 0; i < size; i++) {
			if (player_2.getScore() > list.get(i).getScore()) {
				list.add(i, player_2);
				list.remove(list.size() - 1);
				i = size;
			}
		}
		writeHighScore();
	}

}

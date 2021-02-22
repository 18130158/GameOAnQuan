package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.IPlayer;

public class GameOver extends JFrame implements IFrame, Interface_GameOver {
	private JLabel lbPlayer1, lbPlayer2;
	private JButton btnBack;
	private IMenu menu;

	/**
	 * Create the panel.
	 */
	public GameOver(List<IPlayer> list) {
		getContentPane().setBackground(Color.GREEN);
		init();
		addName(list);
		back();
	}

	public void init() {

		setSize(WIDTHJF, HEIGHTJF);
		setTitle("Ô Ăn Quan");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setBackground(Color.GREEN);
		getContentPane().setLayout(new GridLayout(3, 1, 0, 0));

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblnQuan = new JLabel("\u00D4 \u0102n Quan ");
		lblnQuan.setForeground(Color.RED);
		lblnQuan.setHorizontalAlignment(SwingConstants.CENTER);
		lblnQuan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 60));
		panel.add(lblnQuan);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 3, 0, 0));

		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_2.add(panel_5);

		JLabel lblNewLabel = new JLabel("Game Over ");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		panel_2.add(lblNewLabel);

		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel_2.add(panel_6);

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		panel_3.add(panel_9);

		lbPlayer1 = new JLabel("New label");
		lbPlayer1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbPlayer1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_3.add(lbPlayer1);

		JPanel panel_6_1 = new JPanel();
		panel_6_1.setOpaque(false);
		panel_3.add(panel_6_1);

		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel panel_10 = new JPanel();
		panel_10.setOpaque(false);
		panel_4.add(panel_10);

		lbPlayer2 = new JLabel("New label");
		lbPlayer2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbPlayer2.setHorizontalAlignment(SwingConstants.LEFT);
		panel_4.add(lbPlayer2);

		JPanel panel_6_2 = new JPanel();
		panel_6_2.setOpaque(false);
		panel_4.add(panel_6_2);

		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		getContentPane().add(panel_7);
		panel_7.setLayout(new GridLayout(3, 1, 0, 0));

		JPanel panel_8 = new JPanel();
		panel_8.setOpaque(false);
		panel_7.add(panel_8);

		btnBack = new JButton("OK");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_8.add(btnBack);

	}

	@Override
	public void back() {
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				menu = new Menu();
				menu.setVisible(true);
			}
		});
	}

	// Thay đổi tên trong người chơi trong view
	@Override
	public void addName(List<IPlayer> list) {
		lbPlayer1.setText(list.get(0).getName() + " : " + list.get(0).getScore());
		lbPlayer2.setText(list.get(1).getName() + " : " + list.get(1).getScore());
	}
}

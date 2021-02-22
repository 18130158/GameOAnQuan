package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import model.IModel_HighScore;
import model.IPlayer;

public class HighScoreView extends JFrame implements IHighScore, IFrame {
	private List<JLabel> listLB = new ArrayList<JLabel>();
	private JPanel panel;
	private JButton btnBack, btnReset;
	private IModel_HighScore highScore;
	private List<IPlayer> list;
	private JPanel panel_3;
	private IMenu menu;

	/**
	 * Create the panel.
	 */
	public HighScoreView(IModel_HighScore highScore) {
		this.highScore = highScore;
		setSize(WIDTHJF, HEIGHTJF);
		setTitle("Ô Ăn Quan");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		initComps();
		back();
		reset();
	}

	public void initComps() {
		list = highScore.readHighScore();
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		panel_2.setForeground(Color.GREEN);
		getContentPane().add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblnQuan = new JLabel("\u00D4 \u0102n Quan ");
		lblnQuan.setForeground(Color.RED);
		lblnQuan.setBackground(Color.GREEN);
		lblnQuan.setHorizontalAlignment(SwingConstants.CENTER);
		lblnQuan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 60));
		panel_2.add(lblnQuan);
		panel = new JPanel();
		panel.setBackground(Color.GREEN);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(10, 1, 0, 0));

		for (IPlayer player : list) {
			JLabel lb = new JLabel(" - " + player.getName() + " : " + player.getScore());
			lb.setForeground(Color.RED);
			lb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
			panel_3.add(lb);
			listLB.add(lb);
		}

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setBackground(Color.GREEN);

		btnBack = new JButton("OK");
		btnBack.setBackground(UIManager.getColor("Button.background"));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btnBack);

		btnReset = new JButton("Reset");
		btnReset.setBackground(UIManager.getColor("Button.background"));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btnReset);
	}

	@Override
	public void back() {
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				menu = new Menu();
				menu.setVisible(true);
			}
		});
	}
	//Cài đặt danh sách điểm trở lại là 0
	@Override
	public void reset() {
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				highScore.reset();
				list = highScore.readHighScore();
				for (int i = 0; i < listLB.size(); i++) {
					listLB.get(i).setText(" - " + list.get(i).getName() + " : " + list.get(i).getScore());
				}
			}
		});
	}

}

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class OnePlayer extends Number_Player_Game {
	private JRadioButton rdbtnEasy, rdbtnMedium, rdbtnHard;
	private JTextField textField;
	private int level = 1;

	/**
	 * Launch the application.
	 */

	public OnePlayer() {
		super();
		setSize(WIDTHJF, HEIGHTJF);
		setTitle("Ô Ãn Quan");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setBackground(Color.GREEN);
		init();
		newGame();
		back();
	}

	public void init() {

		getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(10, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1);

		JLabel lblYoursName = new JLabel("T\u00EAn c\u1EE7a b\u1EA1n: ");
		lblYoursName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblYoursName);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(40);
		panel_1.add(textField);

		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		panel_8.setOpaque(false);
		rdbtnEasy = new JRadioButton("D\u1EC5");
		rdbtnEasy.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnEasy.setOpaque(false);
		panel_8.add(rdbtnEasy);
		rdbtnMedium = new JRadioButton("Trung b\u00ECnh");
		rdbtnMedium.setOpaque(false);
		rdbtnMedium.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_8.add(rdbtnMedium);
		rdbtnHard = new JRadioButton("Kh\u00F3");
		rdbtnHard.setOpaque(false);
		rdbtnHard.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_8.add(rdbtnHard);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnEasy);
		bg.add(rdbtnMedium);
		bg.add(rdbtnHard);

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 5, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GREEN);
		panel_2.add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GREEN);
		panel_2.add(panel_4);

		btNewGame = new JButton("OK");
		btNewGame.setForeground(Color.BLACK);
		btNewGame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btNewGame.setBackground(SystemColor.menu);
		panel_2.add(btNewGame);

		btBack = new JButton("Tr\u1EDF l\u1EA1i");
		btBack.setForeground(Color.BLACK);
		btBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btBack.setBackground(SystemColor.menu);
		panel_2.add(btBack);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.GREEN);
		panel_2.add(panel_5);

		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_2.add(panel_7);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.GREEN);
		getContentPane().add(panel_6, BorderLayout.NORTH);

		JLabel lblnQuan = new JLabel("\u00D4 \u0102n Quan ");
		lblnQuan.setForeground(Color.RED);
		lblnQuan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 75));
		panel_6.add(lblnQuan);

	}

	public int addLevel() {
		rdbtnEasy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				level = 1;
			}
		});
		rdbtnMedium.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				level = 4;
			}
		});
		rdbtnHard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				level = 7;
			}
		});
		return level;
	}

	@Override
	public void newGame() {
		level = addLevel();
		// TODO Auto-generated method stub
		btNewGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				String s = textField.getText();
				boardView = new BoardView(s, level);
				boardView.setVisible(true);
				new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						boardView.firstTurn(false);
					}
				}).start();

			}
		});
	}

}

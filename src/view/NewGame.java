package view;

import java.awt.BorderLayout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewGame extends JFrame implements IFrame, INewGame {
	private INumber_Player number_Player;
	private IMenu menu;
	private JButton btOnePlayer;
	private JButton btTwoPlayer;
	private JButton btBack;

	/**
	 * Create the panel.
	 */
	public NewGame() {
		getContentPane().setBackground(Color.GREEN);
		setTitle("Ô Ãn Quan");
		setSize(WIDTHJF, HEIGHTJF);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		initComps();
		onePlayer();
		twoPlayer();
		back();
	}

	public void initComps() {
		// TODO Auto-generated method stub

		getContentPane().setLayout(new BorderLayout(50, 50));
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel_4.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 1, 0, 0));

		JPanel panel_8 = new JPanel();
		panel_8.setOpaque(false);
		panel_6.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("\u00D4 \u0102n Quan ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 75));
		panel_8.add(lblNewLabel, BorderLayout.CENTER);

		JPanel panel_6_1 = new JPanel();
		panel_6_1.setOpaque(false);
		panel_4.add(panel_6_1);
		panel_6_1.setLayout(new GridLayout(5, 7, 10, 10));

		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_6_1.add(panel_5);

		JPanel panel_16 = new JPanel();
		panel_6_1.add(panel_16);
		panel_16.setOpaque(false);

		btOnePlayer = new JButton("1 Ng\u01B0\u1EDDi ch\u01A1i");
		btOnePlayer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btOnePlayer.setForeground(Color.RED);
		btOnePlayer.setBackground(Color.CYAN);
		panel_6_1.add(btOnePlayer);

		JPanel panel_15 = new JPanel();
		panel_6_1.add(panel_15);
		panel_15.setOpaque(false);

		JPanel panel_14 = new JPanel();
		panel_6_1.add(panel_14);
		panel_14.setOpaque(false);

		JPanel panel_13 = new JPanel();
		panel_6_1.add(panel_13);
		panel_13.setOpaque(false);

		JPanel panel_12 = new JPanel();
		panel_6_1.add(panel_12);
		panel_12.setOpaque(false);

		btTwoPlayer = new JButton("2 Ng\u01B0\u1EDDi ch\u01A1i");
		btTwoPlayer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btTwoPlayer.setForeground(Color.RED);
		btTwoPlayer.setBackground(Color.CYAN);
		panel_6_1.add(btTwoPlayer);

		JPanel panel_1 = new JPanel();
		panel_6_1.add(panel_1);
		panel_1.setOpaque(false);

		JPanel panel_3 = new JPanel();
		panel_6_1.add(panel_3);
		panel_3.setOpaque(false);

		JPanel panel_9 = new JPanel();
		panel_6_1.add(panel_9);
		panel_9.setOpaque(false);

		JPanel panel_11 = new JPanel();
		panel_6_1.add(panel_11);
		panel_11.setOpaque(false);
		btBack = new JButton("Tr\u1EDF v\u1EC1");
		btBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btBack.setForeground(Color.RED);
		btBack.setBackground(Color.CYAN);
		panel_6_1.add(btBack);

		JPanel panel_10 = new JPanel();
		panel_6_1.add(panel_10);
		panel_10.setOpaque(false);

		JPanel panel_7 = new JPanel();
		panel_6_1.add(panel_7);
		panel_7.setOpaque(false);

		JPanel panel_2 = new JPanel();
		panel_6_1.add(panel_2);
		panel_2.setOpaque(false);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel_6_1.add(panel);
		panel_6_1.setOpaque(false);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setOpaque(false);
		panel_6_1.add(panel_1_1);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setOpaque(false);
		panel_6_1.add(panel_2_1);
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setOpaque(false);
		panel_6_1.add(panel_3_1);

		JPanel panel_7_1 = new JPanel();
		panel_7_1.setOpaque(false);
		panel_6_1.add(panel_7_1);

		JPanel panel_8_1 = new JPanel();
		panel_8_1.setOpaque(false);
		panel_6_1.add(panel_8_1);

		JPanel panel_9_1 = new JPanel();
		panel_9_1.setOpaque(false);
		panel_6_1.add(panel_9_1);

		JPanel panel_10_1 = new JPanel();
		panel_10_1.setOpaque(false);
		panel_6_1.add(panel_10_1);

		JPanel panel_11_1 = new JPanel();
		panel_11_1.setOpaque(false);
		panel_6_1.add(panel_11_1);
	}

	@Override
	public void onePlayer() {
		btOnePlayer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createNumber_Player_Game(Number_Player_Type.ONEPLAYER);
			}
		});

	}

	@Override
	public void twoPlayer() {
		btTwoPlayer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createNumber_Player_Game(Number_Player_Type.TWOPLAYER);
			}
		});
	}

	public void createNumber_Player_Game(Number_Player_Type numberType) {
		switch (numberType) {
		case ONEPLAYER:
			dispose();
			number_Player = new OnePlayer();
			number_Player.setVisible(true);
			break;
		case TWOPLAYER:
			dispose();
			number_Player = new TwoPlayer();
			number_Player.setVisible(true);
			break;

		default:
			break;
		}
	}

	@Override
	public void back() {
		btBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				menu = new Menu();
				menu.setVisible(true);
				;
			}
		});
	}
}

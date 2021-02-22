package view;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.IBox;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.SystemColor;

public class TwoPlayer extends Number_Player_Game {
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */

	public TwoPlayer() {
		super();
		setSize(WIDTHJF, HEIGHTJF);
		setTitle("Ô Ãn Quan");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		init();
		newGame();
		back();
	}

	public void init() {
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.GREEN);
		getContentPane().add(panel_6, BorderLayout.NORTH);

		JLabel lblnQuan = new JLabel("\u00D4 \u0102n Quan ");
		lblnQuan.setForeground(Color.RED);
		lblnQuan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 75));
		panel_6.add(lblnQuan);
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(10, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1);

		JLabel lbPlayer_1_Name = new JLabel("T\u00EAn ng\u01B0\u1EDDi ch\u01A1i 1:");
		lbPlayer_1_Name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lbPlayer_1_Name);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(40);
		panel_1.add(textField_1);

		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel.add(panel_7);

		JLabel lbPlayer_2_Name = new JLabel("T\u00EAn ng\u01B0\u1EDDi ch\u01A1i 2:");
		lbPlayer_2_Name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_7.add(lbPlayer_2_Name);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(40);
		panel_7.add(textField_2);

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 6, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GREEN);
		panel_2.add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GREEN);
		panel_2.add(panel_4);

		btNewGame = new JButton("OK");
		btNewGame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btNewGame.setBackground(SystemColor.menu);
		panel_2.add(btNewGame);

		btBack = new JButton("Tr\u1EDF l\u1EA1i");
		btBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btBack.setBackground(SystemColor.menu);
		panel_2.add(btBack);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.GREEN);
		panel_2.add(panel_5);

		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		panel_8.setOpaque(false);

	}

	@Override
	public void newGame() {
		// TODO Auto-generated method stub
		btNewGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				String s1 = textField_1.getText();
				String s2 = textField_2.getText();
				boardView = new BoardView(s1, s2);
				boardView.setVisible(true);
				boardView.firstTurn(false);
			}
		});
	}

}

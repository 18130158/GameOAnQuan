package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.HighScoreModel;

public class Menu extends JFrame implements IFrame, IMenu {
	private INewGame newGame;
	private IHighScore highScore;
	private IHelp help;
	private JButton btNewGame;
	private JButton btHighScore;
	private JButton btHelp;
	private JButton btExit;

	public Menu() {

		getContentPane().setBackground(Color.GREEN);
		setTitle("Ô Ãn Quan");
		setSize(WIDTHJF, HEIGHTJF);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		getContentPane().setLayout(null);
		initComps();
		newGame();
		highScore();
		help();
	}

	public void initComps() {
		// TODO Auto-generated method stub
		getContentPane().setLayout(new BorderLayout(0, 50));
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblnQuan = new JLabel("\u00D4 \u0102n Quan ");
		lblnQuan.setForeground(Color.RED);
		lblnQuan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 99));
		panel.add(lblnQuan);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(300, 50));

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_1.add(panel_2, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_1.add(panel_3, BorderLayout.SOUTH);

		JLabel lblNewLabel_1 = new JLabel("          ");
		panel_3.add(lblNewLabel_1);

		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel_1.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new GridLayout(0, 1, 10, 10));

		btNewGame = new JButton("Ch\u01A1i m\u1EDBi");
		btNewGame.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btNewGame.setForeground(Color.RED);
		btNewGame.setBackground(Color.CYAN);
		panel_6.add(btNewGame);

		btHighScore = new JButton("\u0110i\u1EC3m cao");
		btHighScore.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btHighScore.setForeground(Color.RED);
		btHighScore.setBackground(Color.CYAN);
		panel_6.add(btHighScore);

		btHelp = new JButton("H\u01B0\u1EDBng d\u1EABn");
		btHelp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btHelp.setForeground(Color.RED);
		btHelp.setBackground(Color.CYAN);
		panel_6.add(btHelp);

		btExit = new JButton("Tho\u00E1t");
		btExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		btExit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btExit.setForeground(Color.RED);
		btExit.setBackground(Color.CYAN);
		panel_6.add(btExit);

		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_1.add(panel_4, BorderLayout.EAST);

		JLabel lblNewLabel_2 = new JLabel("                   ");
		panel_4.add(lblNewLabel_2);

		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_1.add(panel_5, BorderLayout.WEST);

		JLabel lblNewLabel_3 = new JLabel("                 ");
		panel_5.add(lblNewLabel_3);

	}

	@Override
	public void newGame() {
		btNewGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				newGame = new NewGame();
				newGame.setVisible(true);
			}
		});
	}

	@Override
	public void highScore() {
		btHighScore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();

				highScore = new HighScoreView(new HighScoreModel());
				highScore.setVisible(true);
			}
		});
	}

	@Override
	public void help() {
		btHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				help = new Help();
				help.setVisible(true);
			}
		});
	}
}

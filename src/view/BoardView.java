package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import org.w3c.dom.events.EventException;

import controller.Controller;
import controller.Controller_Interface;
import model.IPlayer;
import model.Model_Interface;
import model.OnePlayer;
import model.TwoPlayer;

public class BoardView extends JFrame
		implements View_Interface, IFrame, IScoreObserver, IStoneObserver, IRestStoneObserver, IGameOver, IDraw {
	private JLabel lbPlayer_1, lbScore_1, lbPlayer_2, lbScore_2, text_1, text_2, lbRestStone_1, lbRestStone_2;
	private JButton btLeft_1, btRight_1, btLeft_2, btRight_2, btnMenu;
	private List<JButton> listButton = new ArrayList<>();
	private Controller_Interface controller;
	private Model_Interface model;
	private Interface_GameOver gameOver;
	private IMenu menu;
	private int z;

	/**
	 * Create the panel.
	 * 
	 * @wbp.parser.constructor
	 */
	public BoardView(String s, int level) {
		init();
		this.model = new OnePlayer(s, this, level);
		this.controller = new Controller(model, this);
		lbPlayer_1.setText("Computer : ");
		lbPlayer_2.setText(s + " : ");
		clickMenu();
	}

	public BoardView(String s1, String s2) {
		init();
		this.model = new TwoPlayer(s1, s2, this);
		this.controller = new Controller(model, this);
		lbPlayer_1.setText(s1 + " : ");
		lbPlayer_2.setText(s2 + " : ");
		clickMenu();
	}

	public void init() {
		getContentPane().setBackground(Color.GREEN);
		setSize(WIDTHJF, HEIGHTJF);
		setTitle("Ô Ăn Quan");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setSize(400, 400);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		getContentPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(3, 1, 5, 15));

		JPanel panel_13 = new JPanel();
		panel_13.setOpaque(false);
		panel_1.add(panel_13);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setOpaque(false);
		panel_1.add(panel_1_1);
		panel_1_1.setLayout(new GridLayout(0, 4, 5, 5));

		JLabel lblNewLabel = new JLabel("");
		panel_1_1.add(lblNewLabel);

		lbPlayer_1 = new JLabel("Player_1 : ");
		lbPlayer_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbPlayer_1.setForeground(Color.RED);
		lbPlayer_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1_1.add(lbPlayer_1);

		lbScore_1 = new JLabel("0");
		lbScore_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbScore_1.setForeground(Color.RED);
		panel_1_1.add(lbScore_1);

		text_1 = new JLabel("Lượt của bạn");
		text_1.setHorizontalAlignment(SwingConstants.LEFT);
		text_1.setForeground(Color.RED);
		text_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1_1.add(text_1);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setOpaque(false);
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(new GridLayout(1, 4, 5, 5));

		JPanel panel_8 = new JPanel();
		panel_8.setOpaque(false);
		panel_2_1.add(panel_8);

		btLeft_1 = new JButton("<<");
		btLeft_1.setEnabled(false);

		panel_2_1.add(btLeft_1);

		btRight_1 = new JButton(">>");
		btRight_1.setEnabled(false);

		panel_2_1.add(btRight_1);

		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		panel_2_1.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("Số quân còn lại:");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_9.add(lblNewLabel_1);

		lbRestStone_1 = new JLabel(" ");
		lbRestStone_1.setForeground(Color.RED);
		lbRestStone_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_9.add(lbRestStone_1);
		getContentPane().add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		panel_2.add(panel_4, BorderLayout.NORTH);

		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setVgap(10);
		flowLayout_1.setHgap(10);
		panel_2.add(panel_5, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(10, 0));

		JPanel panel_a = new JPanel();
		JPanel panel_b = new JPanel();
		JPanel panel_c = new JPanel();
		panel_a.setLayout(new GridLayout(0, 1, 0, 0));
		panel_b.setLayout(new GridLayout(2, 5, 20, 20));
		panel_c.setLayout(new GridLayout(0, 1, 0, 0));
		panel_a.setOpaque(false);
		panel_b.setOpaque(false);
		panel_c.setOpaque(false);

		for (int i = 0; i < 12; i++) {

			if (i != 0 && i != 6) {
				JButton bt = new JButton("  5  ");
				bt.setFont(new Font("Tahoma", Font.BOLD, 15));
				listButton.add(bt);

			} else {
				JButton bt = new JButton("      10       ");
				bt.setFont(new Font("Tahoma", Font.BOLD, 18));
				listButton.add(bt);
			}

		}

		for (int i = 1; i < 6; i++) {
			panel_b.add(listButton.get(i));
		}

		for (int i = 11; i > 6; i--) {
			panel_b.add(listButton.get(i));
		}

		panel_a.add(listButton.get(0));
		listButton.get(0).setEnabled(false);
		panel_c.add(listButton.get(6));
		listButton.get(6).setEnabled(false);

		panel.add(panel_a, BorderLayout.WEST);
		panel.add(panel_b, BorderLayout.CENTER);
		panel.add(panel_c, BorderLayout.EAST);
		panel.setOpaque(false);

		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel_2.add(panel, BorderLayout.CENTER);
		panel.setSize(350, 350);
		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setHgap(30);
		panel_2.add(panel_6, BorderLayout.WEST);
		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		FlowLayout flowLayout_3 = (FlowLayout) panel_7.getLayout();
		flowLayout_3.setVgap(10);
		flowLayout_3.setHgap(30);
		panel_2.add(panel_7, BorderLayout.EAST);

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		getContentPane().add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(3, 1, 0, 15));

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setOpaque(false);
		panel_3.add(panel_4_1);
		panel_4_1.setLayout(new GridLayout(1, 4, 5, 5));

		JPanel panel_10 = new JPanel();
		panel_10.setOpaque(false);
		panel_4_1.add(panel_10);

		btLeft_2 = new JButton("<<");
		btLeft_2.setEnabled(false);

		panel_4_1.add(btLeft_2);

		btRight_2 = new JButton(">>");
		btRight_2.setEnabled(false);

		panel_4_1.add(btRight_2);

		JPanel panel_11 = new JPanel();
		panel_11.setOpaque(false);
		panel_4_1.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel_1_1 = new JLabel("Số quân còn lại:");
		lblNewLabel_1_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_11.add(lblNewLabel_1_1);

		lbRestStone_2 = new JLabel(" ");
		lbRestStone_2.setForeground(new Color(30, 144, 255));
		lbRestStone_2.setHorizontalAlignment(SwingConstants.LEFT);
		panel_11.add(lbRestStone_2);

		JPanel panel_5_1 = new JPanel();
		panel_5_1.setOpaque(false);
		panel_3.add(panel_5_1);
		panel_5_1.setLayout(new GridLayout(0, 4, 0, 0));

		JLabel label = new JLabel("");
		panel_5_1.add(label);

		lbPlayer_2 = new JLabel("Player_2 : ");
		lbPlayer_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbPlayer_2.setForeground(new Color(30, 144, 255));
		lbPlayer_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_5_1.add(lbPlayer_2);

		lbScore_2 = new JLabel("0");
		lbScore_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbScore_2.setForeground(new Color(30, 144, 255));
		panel_5_1.add(lbScore_2);

		text_2 = new JLabel("Lượt của bạn");
		text_2.setHorizontalAlignment(SwingConstants.LEFT);
		text_2.setForeground(new Color(30, 144, 255));
		text_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5_1.add(text_2);

		JPanel panel_12 = new JPanel();
		panel_3.add(panel_12);
		panel_12.setOpaque(false);
		panel_12.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_14 = new JPanel();
		panel_14.setOpaque(false);
		panel_12.add(panel_14);

		JPanel panel_16 = new JPanel();
		panel_16.setOpaque(false);
		panel_12.add(panel_16);
		panel_16.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_15 = new JPanel();
		panel_15.setOpaque(false);
		panel_16.add(panel_15);

		JPanel panel_17 = new JPanel();
		panel_17.setOpaque(false);
		panel_16.add(panel_17);
		panel_17.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_18 = new JPanel();
		panel_18.setOpaque(false);
		panel_17.add(panel_18);

		btnMenu = new JButton("Menu");
		panel_17.add(btnMenu);

	}

	public void clickMenu() {
		btnMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				menu = new Menu();
				menu.setVisible(true);
			}
		});
	}

	// Xử lý sự kiện:
	// -Lấy số thứ tự của ô
	// - Thêm sự kiện button Left, Right tương ứng của ô
	// +Nếu ô được chọn từ 1 đến 5 thì button btLeft_1, btRight_1 được thêm sự kiện
	// +Nếu ô được chọn từ 7 đến 11 thì button btLeft_2, btRight_2 được thêm sự kiện
	// +Nếu btLeft được chọn thì direction là false
	// +Nếu btRight được chọn thì direction là true

	public void event(int index) {
		z = 1;
		if (index > 0 && index < 6) {
			listButton.get(index).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					btLeft_1.setEnabled(true);
					btRight_1.setEnabled(true);
					btLeft_1.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (z > 0) {
								for (int j = 1; j < 6; j++) {
									listButton.get(j).setEnabled(false);
								}
								btLeft_1.setEnabled(false);
								btRight_1.setEnabled(false);
								controller.move(index, false, true);
								z--;
							}

						}
					});

					btRight_1.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub

							if (z > 0) {
								for (int j = 1; j < 6; j++) {
									listButton.get(j).setEnabled(false);
								}
								btLeft_1.setEnabled(false);
								btRight_1.setEnabled(false);
								controller.move(index, true, true);
								z--;
							}

						}
					});

				}
			});
		} else if (index > 6 && index < 12)

		{
			listButton.get(index).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					btLeft_2.setEnabled(true);
					btRight_2.setEnabled(true);
					btLeft_2.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							// TODO Auto-generated method stub
							if (z > 0) {
								for (int j = 7; j < 12; j++) {
									listButton.get(j).setEnabled(false);
								}
								btLeft_2.setEnabled(false);
								btRight_2.setEnabled(false);
								controller.move(index, false, false);

								z--;
							}

						}
					});

					btRight_2.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (z > 0) {
								for (int j = 7; j < 12; j++) {
									listButton.get(j).setEnabled(false);
								}
								btLeft_2.setEnabled(false);
								btRight_2.setEnabled(false);
								controller.move(index, true, false);
								z--;

							}

						}
					});
				}

			});

		}
	}

	// -Chuyển lượt của người chơi
	// -Cài đặt lại các button:
	// + Nếu người chơi 1 thì button 1 đến 5 cài đặt được phép chọn và thêm sự kiện
	// vào các button đó và các button từ 7 đến 11 cài đặt không được phép chọn
	// + Nếu người chơi 2 thì button 7 đến 11 cài đặt được phép chọn và thêm sự kiện
	// vào các button đó và các button từ 1 đến 5 cài đặt không được phép chọn
	// -Cài đặt lại các button Hướng không được chọn
	@Override
	public void firstTurn(boolean turn) {
		model.turnOver(turn);
	}

	@Override
	public void turnOver(boolean turn) {
		if (turn) {
			text_1.setText("Đến lượt của bạn!");
			text_2.setText("");
			for (int i = 1; i < 6; i++) {
				listButton.get(i).setEnabled(true);
				event(i);
			}
			for (int i = 7; i < 12; i++) {
				listButton.get(i).setEnabled(false);
			}

		} else {
			text_1.setText("");
			text_2.setText("Đến lượt của bạn!");
			for (int i = 1; i < 6; i++) {
				listButton.get(i).setEnabled(false);

			}
			for (int i = 7; i < 12; i++) {
				listButton.get(i).setEnabled(true);
				event(i);

			}

		}
		btLeft_1.setEnabled(false);
		btRight_1.setEnabled(false);
		btLeft_2.setEnabled(false);
		btRight_2.setEnabled(false);
	}

	// Xử lý đổi lượt của của Máy
	// Các button từ 1 đến 5 được phép chọn
	// Các button 7 đến 11 không được phép chọn
	@Override
	public void turnOverComputer() {
		text_1.setText("Lượt của Máy");
		text_2.setText("");
		btLeft_2.setEnabled(false);
		btRight_2.setEnabled(false);
		for (int i = 1; i < 6; i++) {
			listButton.get(i).setEnabled(false);
		}
		for (int i = 7; i < 12; i++) {
			listButton.get(i).setEnabled(false);
		}
	}

	// Cập nhật số điểm của người chơi
	@Override
	public void updateScore(int score, boolean turn) {
		// TODO Auto-generated method stub
		if (turn) {
			lbScore_1.setText(score + "");
		} else {
			lbScore_2.setText(score + "");
		}
	}

	// Hàm thay đổi màu trong ô
	@Override
	public void draw(int index, boolean turn) {
		// TODO Auto-generated method stub
		if (turn) {
			listButton.get(index).setBackground(Color.RED);
		} else {
			listButton.get(index).setBackground(Color.BLUE);
		}
	}

	@Override
	public void reDraw(int index) {
		// TODO Auto-generated method stub
		listButton.get(index).setBackground(UIManager.getColor("Button.background"));
	}

	// Cập nhật số dân trong ô
	@Override
	public void updateStone(int index, int stone) {
		// TODO Auto-generated method stub
		if (index == 0 || index == 6) {
			listButton.get(index).setText("      " + stone + "       ");
		} else {
			listButton.get(index).setText("  " + stone + "  ");
		}
	}

	// Cập nhật số dân còn lại dùng để rải
	@Override
	public void updateRestStone(int stone, boolean turn) {
		// TODO Auto-generated method stub
		if (turn) {
			lbRestStone_1.setText(stone + "");
		} else {
			lbRestStone_2.setText(stone + "");
		}
	}

	// Mở lớp JFrame GameOver
	@Override
	public void gameOver(List<IPlayer> listPlayer) {
		// TODO Auto-generated method stub
		dispose();
		gameOver = new GameOver(listPlayer);
		gameOver.setVisible(true);
	}

}

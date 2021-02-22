package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class Number_Player_Game extends JFrame implements INumber_Player, IFrame {
	private INewGame newGame;
	protected View_Interface boardView;
	protected JButton btNewGame, btBack;

	public Number_Player_Game() {
		super();
	}

	@Override
	public abstract void newGame();

	@Override
	public void back() {
		// TODO Auto-generated method stub
		btBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();

				newGame = new NewGame();
				newGame.setVisible(true);
			}
		});
	}

}

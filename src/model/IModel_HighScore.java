package model;

import java.util.List;

public interface IModel_HighScore {
	public List<IPlayer> readHighScore();

	public void writeHighScore();

	public void reset();

	public void update(List<IPlayer> listPlayer);
}

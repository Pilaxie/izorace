package game.state.listener;

import game.state.Game;
import nightingale.ui.NActionListener;
import nightingale.ui.NUIElement;

public class GameActionListener implements NActionListener {

	private Game state;
	public GameActionListener(Game state) { this.state = state; };
	
	@Override
	public void actionPerform(NUIElement element) {
		
	}

}
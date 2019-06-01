package game.state.listener;

import game.IzoRace;
import game.state.Game;
import nightingale.ui.NActionListener;
import nightingale.ui.NUIElement;

public class GameActionListener implements NActionListener {

	private Game state;
	public GameActionListener(Game state) { this.state = state; };
	
	@Override
	public void actionPerform(NUIElement element) {
		if(element.getName() == "RESUME") {
			state.paused = false;
		}else if(element.getName() == "TO MENU") {
			IzoRace.stateHandler.setState("MENU_STATE");
		}
	}

}
package game.state.listener;

import game.IzoRace;
import game.state.Menu;
import nightingale.ui.NActionListener;
import nightingale.ui.NUIElement;

public class MenuActionListener implements NActionListener {

	private Menu state;
	public MenuActionListener(Menu state) { this.state = state; };
	
	@Override
	public void actionPerform(NUIElement element) {
		if(element.getName() == "EXIT_BUTTON") System.exit(1);
		else if( element.getName() == "SETTINGS_BUTTON" )  IzoRace.stateHandler.setState("SETTINGS_STATE");
		else if( element.getName() == "GAME_BUTTON" ) {
			IzoRace.stateHandler.setState("GAME_STATE");
		}
	}

}

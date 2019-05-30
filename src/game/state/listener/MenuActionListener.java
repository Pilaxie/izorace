package game.state.listener;

import game.state.Menu;
import nightingale.ui.NActionListener;
import nightingale.ui.NUIElement;

public class MenuActionListener implements NActionListener {

	private Menu state;
	public MenuActionListener(Menu state) { this.state = state; };
	
	@Override
	public void actionPerform(NUIElement element) {
		if(element.getName() == "EXIT_BUTTON") System.exit(1);
	}

}

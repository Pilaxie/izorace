package game.state.listener;

import game.state.Settings;
import nightingale.ui.NActionListener;
import nightingale.ui.NUIElement;

public class SettingsActionListener implements NActionListener {

	private Settings state;
	public SettingsActionListener(Settings state) { this.state = state; };
	
	@Override
	public void actionPerform(NUIElement element) {
		
	}

}

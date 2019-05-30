package game.state.listener;

import game.IzoRace;
import game.state.Settings;
import nightingale.ui.NActionListener;
import nightingale.ui.NUIElement;

public class SettingsActionListener implements NActionListener {

	private Settings state;
	public SettingsActionListener(Settings state) { this.state = state; };
	
	@Override
	public void actionPerform(NUIElement element) {
		if(element.getName() == "DEFAULT_SETTINGS") {
			Settings.setDefaultSettings();
			Settings.save();
			Settings.apply();
		}
		if(element.getName() == "BACK_BUTTON") IzoRace.stateHandler.setState("MENU_STATE");
	}

}

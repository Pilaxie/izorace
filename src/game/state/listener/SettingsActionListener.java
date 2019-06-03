package game.state.listener;

import game.IzoRace;
import game.state.Settings;
import nightingale.ui.NActionListener;
import nightingale.ui.NButton;
import nightingale.ui.NLabel;
import nightingale.ui.NUIElement;

public class SettingsActionListener implements NActionListener {

	private Settings state;
	public SettingsActionListener(Settings state) { this.state = state; };
	
	@Override
	public void actionPerform(NUIElement element) {
		if(element.getName() == "DEFAULT_SETTINGS") Settings.setDefaultSettings();	
		else if(element.getName() == "BACK_BUTTON") IzoRace.stateHandler.setState("MENU_STATE");
		else if (element.getName() == "FULLSCREEN_BUTTON") Settings.set("FULLSCREEN", (Settings.get("FULLSCREEN") == 0) ? 1 : 0);
		else if (element.getName() == "ANTI-ALIASING_BUTTON") Settings.set("ANTI-ALIASING", (Settings.get("ANTI-ALIASING") == 0) ? 1 : 0);
		else if (element.getName() == "+VOLUME_BUTTON") {
			if (Settings.get("VOLUME") >= 100) return;
			Settings.set("VOLUME", Settings.get("VOLUME") + 5);	
		}
		else if (element.getName() == "-VOLUME_BUTTON") {
			if (Settings.get("VOLUME") <= 0) return;	
			Settings.set("VOLUME", Settings.get("VOLUME") - 5);
		}
		NLabel label = (NLabel) state.uigroup.getElement("FULLSCREEN_LABEL");
		
		label.setText(Integer.toString(Settings.get("FULLSCREEN")));
			
		label = (NLabel) state.uigroup.getElement("VOLUME_LABEL");
		label.setText(Integer.toString(Settings.get("VOLUME")));
		
		label = (NLabel) state.uigroup.getElement("ANTI-ALIASING_LABEL");
		label.setText(Integer.toString(Settings.get("ANTI-ALIASING")));
		
		Settings.save();
		Settings.apply();
	}

}

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
		else if (element.getName() == "+VOLUME_BUTTON") {
			if (Settings.get("VOLUME") >= 100) return;
			Settings.set("VOLUME", Settings.get("VOLUME") + 5);	
		}
		else if (element.getName() == "-VOLUME_BUTTON") {
			if (Settings.get("VOLUME") <= 0) return;	
			Settings.set("VOLUME", Settings.get("VOLUME") - 5);
		}
		
		NLabel fullscreenLable = (NLabel) state.uigroup.getElement("FULLSCREEN_LABEL");
		fullscreenLable.setText(Integer.toString(Settings.get("FULLSCREEN")));
		
		NLabel volumeLabel = (NLabel) state.uigroup.getElement("VOLUME_LABEL");
		volumeLabel.setText(Integer.toString(Settings.get("VOLUME")));
		
		Settings.save();
		Settings.apply();
	}

}

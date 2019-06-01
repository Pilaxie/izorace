package game.state;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import game.IzoRace;
import game.state.listener.MenuActionListener;
import nightingale.state.NState;
import nightingale.ui.NActionListener;
import nightingale.ui.NButton;
import nightingale.ui.NLabel;
import nightingale.ui.NUIGroup;

public class Menu implements NState{
	protected NActionListener listener = new MenuActionListener(this);
	
	NUIGroup uigroup = new NUIGroup();
	public Menu(){
		uigroup.addElement("GAME_BUTTON", new NButton(100, 300, 100, 55));
		uigroup.addElement("SETTINGS_BUTTON", new NButton(100, 365, 100, 55));
		uigroup.addElement("EXIT_BUTTON", new NButton(100, 430, 100, 55));
		uigroup.addElement("TITLE_LABEL", new NLabel("Izo race", 300, 60, 150, 40));
		uigroup.setActionListener(listener);
	}
	
	@Override
	public void install() {}
	
	@Override
	public void draw(Graphics g, Graphics2D g2d, AffineTransform at) {
		uigroup.draw(g, g2d, at);
	}

	@Override
	public void update() {
		uigroup.perform(IzoRace.in);
	}

}

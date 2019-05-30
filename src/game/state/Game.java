package game.state;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import game.state.listener.GameActionListener;
import nightingale.state.NState;
import nightingale.ui.NActionListener;

public class Game implements NState{
	protected NActionListener listener = new GameActionListener(this);

	@Override
	public void draw(Graphics g, Graphics2D g2d, AffineTransform at) {
		
	}

	@Override
	public void update() {
		
	}

}
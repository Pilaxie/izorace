package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import nightingale.graph.NDrawer;

public class Drawer implements NDrawer{
	
	@Override
	public void draw(Graphics g, Graphics2D g2d, AffineTransform at) {
		IzoRace.instance.stateHandler.drawCurrentState(g, g2d, at);
		
		g.setColor(Color.YELLOW);
		g.drawString("FPS: "+IzoRace.instance.getFPS(), 0, g.getFont().getSize());
	}
}
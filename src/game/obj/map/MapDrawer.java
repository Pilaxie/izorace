package game.obj.map;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import nightingale.game.map.NMapTile;

public interface MapDrawer {

	public void drawTile(NMapTile tile, Graphics g, Graphics2D g2d, AffineTransform at);
	
}

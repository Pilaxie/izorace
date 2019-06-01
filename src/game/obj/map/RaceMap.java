package game.obj.map;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.List;

import nightingale.game.NGameObject;
import nightingale.game.map.NMap;

public class RaceMap extends NMap{
	public    final static int         TILE_WIDTH = 32;
	public    final static int        TILE_HEIGHT = 32;
	protected final static int[] IMPASSABLE_TYPES = new int[] { 0, 2 };
	
	protected NGameObject[] checkpoints = null;
	
	public RaceMap(int[][] tiles, List<NGameObject> checkpoints) {
		super(tiles, IMPASSABLE_TYPES, 0, 0, TILE_WIDTH, TILE_HEIGHT);
		try {
			this.checkpoints = new NGameObject[checkpoints.size()];
			for(int i=0;i<this.checkpoints.length;i++)
				this.checkpoints[i] = checkpoints.get(i);
		}catch(NullPointerException e) {
			System.out.println("NO CHECKPOINTS");
		}
	}
	
	public void draw(MapDrawer drawer, Graphics g, Graphics2D g2d, AffineTransform at) {
		for(int i=0;i<tiles.length;i++) {
			for(int j=0;j<tiles[0].length;j++) {
				drawer.drawTile(tiles[i][j], g, g2d, at);
			}
		}
	}
}
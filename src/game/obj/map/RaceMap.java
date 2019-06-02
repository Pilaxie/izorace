package game.obj.map;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.List;

import nightingale.game.NGameObject;
import nightingale.game.map.NMap;
import nightingale.game.map.NMapTile;

public class RaceMap extends NMap{
	public    final static int         TILE_WIDTH = 32;
	public    final static int        TILE_HEIGHT = 32;
	protected final static int[] IMPASSABLE_TYPES = new int[] { 0, 2 };

	protected NGameObject[] checkpoints = null;
	
	public RaceMap(int[][] tiles, List<NGameObject> checkpoints) {
		super(tiles, IMPASSABLE_TYPES, 0, 0, TILE_WIDTH, TILE_HEIGHT);
		
		for(int i=0;i<this.tiles.length;i++) {
			for(int j=0;j<this.tiles[0].length;j++) {
				NMapTile extra = this.tiles[i][j].copy();
				this.tiles[i][j] = new RaceMapTile(extra.getType(), extra.I(), extra.J());
				this.tiles[i][j].setX(extra.getX());
				this.tiles[i][j].setY(extra.getY());
				this.tiles[i][j].walkable = extra.walkable;
				this.tiles[i][j].setWidth(extra.getWidth());
				this.tiles[i][j].setHeight(extra.getHeight());
				((RaceMapTile)this.tiles[i][j]).init();
			}
		}
		
		try {
			this.checkpoints = new NGameObject[checkpoints.size()];
			for(int i=0;i<this.checkpoints.length;i++)
				this.checkpoints[i] = checkpoints.get(i);
		}catch(NullPointerException e) {
			System.out.println("NO CHECKPOINTS");
		}
	}
	
	public NMapTile getTile(int i, int j) {
		return tiles[i][j];
	}
	
	public NMapTile[][] getTiles(){
		return tiles;
	}
	
	public void draw(MapDrawer drawer, Graphics g, Graphics2D g2d, AffineTransform at) {
		for(int i=0;i<tiles.length;i++) {
			for(int j=0;j<tiles[0].length;j++) {
				drawer.drawTile(tiles[i][j], g, g2d, at);
			}
		}
	}
}
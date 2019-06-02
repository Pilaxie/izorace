package game.obj.map;

import game.phys.hitbox.Hitbox;
import nightingale.game.map.NMapTile;

public class RaceMapTile extends NMapTile{

	protected Hitbox hitbox;
	
	
	public RaceMapTile(int type, int i, int j) {
		super(type, i, j);
	}
	
}

package game.obj.map;

import game.phys.hitbox.Hitbox;
import game.phys.hitbox.RectHitbox;
import nightingale.game.map.NMapTile;

public class RaceMapTile extends NMapTile{

	protected Hitbox hitbox;
	
	public Hitbox getHitbox() { return hitbox; }
	
	public RaceMapTile(int type, int i, int j) {
		super(type, i, j);
	}
	
	public void init() {
		switch(type) {
		case 2:
			hitbox = new RectHitbox(this.getX(), this.getY(), this.getWidth(), this.getHeight());
			break;
		}
	}
	
}

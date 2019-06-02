package game.obj.map;

import game.phys.hitbox.Hitbox;
import game.phys.hitbox.RectHitbox;
import game.phys.hitbox.TriangleHitbox;
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
		case 3:
			hitbox = new TriangleHitbox(
					getX()           , getY(),
					getX()           , getY()+getHeight(),
					getX()+getWidth(), getY()
					);
			break;
		case 4:
			hitbox = new TriangleHitbox(
					getX()           , getY()+getHeight(),
					getX()+getWidth(), getY()+getHeight(),
					getX()+getWidth(), getY()
					);
		}
	}
	
}

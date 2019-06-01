package game.obj;

import game.phys.Hitbox;
import nightingale.game.NGameObject;

public class Car extends NGameObject{

	protected Cars kind = Cars.Hatch;
	
	protected Hitbox hitbox;
	
	public Hitbox getHitbox() { return hitbox; }
	
	public Car(Cars kind, int x, int y) {
		super(x, y, kind.getWidth(), kind.getHeight());
		this.kind = kind;
		this.hitbox = new Hitbox(getX(), getY(), getWidth(), getHeight());
	}
	
	public void update() {
		hitbox.update();
	}
	
}

package game.obj;

import game.phys.Hitbox;
import nightingale.game.NGameObject;

public class Car extends NGameObject{

	protected Cars kind = null;
	protected Hitbox hitbox = null;
	
	protected float maxV = 0;
	
	// Getters
	public Hitbox getHitbox() { return hitbox; }	
	
	public Car(Cars kind, int x, int y) {
		super(x, y, kind.getSpecs().getWidth(), kind.getSpecs().getHeight());
		this.kind = kind;
		this.maxV = this.kind.getSpecs().getMaxV();
		this.hitbox = new Hitbox(getX(), getY(), getWidth(), getHeight());
	}
	
	public void update() {
		hitbox.update();
	}
	
}

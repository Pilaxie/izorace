package game.obj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import game.phys.Hitbox;
import nightingale.game.NGameObject;
import nightingale.util.NCamera;

public class Car extends NGameObject{
	protected Cars kind = null;
	protected Hitbox hitbox = null;
	
	protected float maxV = 0;
	protected float v = 0;
	protected float turningSpeed = 0;
	private float acceleration = 0;
	private float brake = 0;
	
	// Getters
	public Hitbox getHitbox() { return hitbox; }	
	
	public float         getMaxV() { return         maxV; }
	public float               V() { return            v; }
	public float getTurningSpeed() { return turningSpeed; }
	public float getAcceleration() { return acceleration; }	
	public float getBrake()        { return        brake; }
	
	// Setters
	public void setV(float v) {
		this.v = v;
		if(V() > getMaxV()) this.v = getMaxV();
		else if (V() < 0 ) this.v = 0;
	}
	
	public void Gas() {
		setV(V()+getAcceleration());
	}
	
	public void Brake() {
	}
	
	public Car(Cars kind, int x, int y) {
		super(x, y, kind.getSpecs().getWidth(), kind.getSpecs().getHeight());
		this.kind = kind;
		this.maxV = this.kind.getSpecs().getMaxV();
		this.hitbox = new Hitbox(getX(), getY(), getWidth(), getHeight());
	}
	
	public void update() {
		hitbox.update();
	}
	
	public void draw(Graphics g, Graphics2D g2d, AffineTransform at, NCamera cam) {
		at = AffineTransform.getTranslateInstance(getX(cam)+getWidth(cam)/2, getY(cam)+getHeight(cam)/2);
		at.scale(cam.delta, cam.delta);
		at.rotate(Math.toRadians(hitbox.getAngle()));
		g.setColor(Color.YELLOW);
		hitbox.draw(g);
	}
}

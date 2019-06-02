package game.obj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import game.phys.hitbox.Hitbox;
import game.phys.hitbox.RectHitbox;
import nightingale.game.NGameObject;
import nightingale.util.NCamera;

public class Car extends NGameObject{
	protected Cars kind = null;
	protected Hitbox hitbox = null;
	
	protected float angle = 0;
	protected float maxV = 0;
	protected float v = 0;
	protected float turningSpeed = 0;
	private float acceleration = 0;
	private float brake = 0;
	
	// Getters
	public Hitbox getHitbox() { return hitbox; }	
	
	public float        getAngle() { return        angle; }
	public float         getMaxV() { return         maxV; }
	public float               V() { return            v; }
	public float getTurningSpeed() { return turningSpeed; }
	public float getAcceleration() { return acceleration; }	
	public float        getBrake() { return        brake; }
	
	// Setters
	public void setV(float v) {
		this.v = v;
		if(V() > getMaxV()) this.v = getMaxV();
		else if (V() < 0 ) this.v = 0;
	}
	
	private void setCoordsByCenter(float cx, float cy) {
		setX(cx - getWidth()/2);
		setY(cy - getHeight()/2);
	}
	
	private void checkAngleRange() {
		if(this.angle < 0)
			this.angle += 360;
		else if(this.angle > 360)
			this.angle -= 360;
	}
	
	public void turnLeft() {
		angle -= turningSpeed;
		checkAngleRange();
	}
	
	public void turnRight() {
		angle += turningSpeed;
		checkAngleRange();
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
		this.acceleration = this.kind.getSpecs().getAcceleration();
		this.turningSpeed = this.kind.getSpecs().getTurningSpeed();
		this.brake = this.kind.getSpecs().getBrake();
		this.hitbox = new RectHitbox(getX(), getY(), getWidth(), getHeight());
	}
	
	public void move(float angle) {
		// Move
		if(v!=0) {
			float _cx = (float)(getCenterX() - (V()*Math.cos(Math.PI*(angle+90)/180)));
			float _cy = (float)(getCenterY() - (V()*Math.sin(Math.PI*(angle+90)/180)));
			setCoordsByCenter(_cx, _cy);
			v -= 0.04;
			if( v < 0) v = 0;
		}
	}
	
	public void update() {
		// Hitbox update
		hitbox.setX(getX());
		hitbox.setY(getY());
		hitbox.setAngle(getAngle());
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

package game.phys.hitbox;

import java.awt.Graphics;

import nightingale.game.NGameObject;

public abstract class Hitbox extends NGameObject {

	protected float angle = 0;
	
	public Point[] points;
	public Line[] lines;
	
	public float getAngle() { return angle; }
	
	public void setAngle(float angle) { 
		this.angle = angle;
		if(this.angle < 0)
			this.angle += 360;
		else if(this.angle > 360)
			this.angle -= 360;
	}
	
	protected float R = 0;
	
	public float R() { return R; }
	
	public Hitbox() {}

	public abstract void update();
	
	public boolean collideWith(Hitbox hitbox) {
		for(int i=0;i<lines.length;i++)
			for(int j=0;j<hitbox.lines.length;j++)
				if (Line.isLineIntersects(lines[i], hitbox.lines[j]))
					return true;
		
		return false;
	}
	
	public void draw(Graphics g) {
		for(int i=0;i<lines.length;i++)
			g.drawLine((int)lines[i].a.x, (int)lines[i].a.y, (int)lines[i].b.x, (int)lines[i].b.y);
	}
	
}

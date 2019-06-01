package game.obj;

final class Specifications{
	private int width, height;
	private float maxVelocity;
	private float turningSpeed;
	private float acceleration;
	private float brake;
	
	public Specifications(int width, int height, float maxV, float turningSpeed, float acceleration, float brake) {
		this.width = width;
		this.height = height;
		this.maxVelocity = maxV;
		this.turningSpeed = turningSpeed;
		this.acceleration = acceleration;
		this.brake = brake;
	}
	
	public int   getWidth()        { return        width; }
	public int   getHeight()       { return       height; }
	public float getMaxV()         { return  maxVelocity; }
	public float getTurningSpeed() { return turningSpeed; }
	public float getAcceleration() { return acceleration; }	
	public float getBrake()        { return        brake; }
}

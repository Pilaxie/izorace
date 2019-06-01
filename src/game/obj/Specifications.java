package game.obj;

final class Specifications{
	private int width, height;
	private float maxVelocity;
	
	public Specifications(int width, int height, float maxV) {
		this.width = width;
		this.height = height;
		this.maxVelocity = maxV;
	}
	
	public int getWidth()  { return       width; }
	public int getHeight() { return      height; }
	public float getMaxV() { return maxVelocity; }
}

package game.obj;

import java.awt.Dimension;

public enum Cars {
	Long  (new Dimension(36, 60)),
	Hatch (new Dimension(30, 45));
	
	private Dimension dim;
	
	Cars(Dimension dim){ this.dim = dim; }
	
	public int getWidth() { return dim.width; }
	public int getHeight() { return dim.height; }
}
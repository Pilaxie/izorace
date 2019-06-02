package game.obj;

public enum Cars {	
	Hatch (new Specifications(10, 15, 2, 4f, 1.2f, 2.8f));
	
	private Specifications spec;
	
	Cars(Specifications spec){ this.spec = spec; }
	
	public Specifications getSpecs() { return spec; }
}
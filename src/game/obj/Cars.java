package game.obj;

public enum Cars {	
	Long  (new Specifications(36, 60, 8, 1.9f, 1.7f, 3.3f)),
	Hatch (new Specifications(30, 45, 6, 2.7f, 1.1f, 2.8f));
	
	private Specifications spec;
	
	Cars(Specifications spec){ this.spec = spec; }
	
	public Specifications getSpecs() { return spec; }
}
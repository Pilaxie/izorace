package game.obj;

public enum Cars {	
	Long  (new Specifications(36, 60, 8)),
	Hatch (new Specifications(30, 45, 6));
	
	private Specifications spec;
	
	Cars(Specifications spec){ this.spec = spec; }
	
	public Specifications getSpecs() { return spec; }
}
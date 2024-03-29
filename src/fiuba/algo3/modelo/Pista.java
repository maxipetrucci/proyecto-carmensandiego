package fiuba.algo3.modelo;

public class Pista {
	public final static String PISTA_POR_DEFECTO_LUGAR = "No se nada sobre ese sujeto.";
	public final static String PISTA_POR_DEFECTO_LADRON = "";	
	private String pistaLugar;
	private String pistaLadron;
	
	
	public Pista() {
		this.pistaLugar = PISTA_POR_DEFECTO_LUGAR;
		this.pistaLadron = PISTA_POR_DEFECTO_LADRON;
	}
	
    public Pista(String pista) {
        this.pistaLugar = pista;
        this.pistaLadron = "";
    }
	
	public void setPistaLadron(String pista) {
		this.pistaLadron = " " + pista;
	}

    public String getPista() {
        return this.pistaLugar + this.pistaLadron;
    }
}

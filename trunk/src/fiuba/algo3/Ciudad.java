package fiuba.algo3;
import java.awt.geom.Arc2D.Double;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class Ciudad {
	private String nombre;
	private Coordenada coordenadas;
    private Edificio edificioCultural;
    private Edificio edificioEconomia;
    private Edificio edificioTransporte;
    private ArrayList<Ciudad> ciudadesConectadas;
	private boolean acaEstaElLadron;

	public Ciudad(String nombre, Coordenada coordenadas) {
		this.nombre = nombre;
		this.coordenadas = coordenadas;
        edificioCultural = new Edificio();
        edificioEconomia = new Edificio();
        edificioTransporte = new Edificio();
        ciudadesConectadas = new ArrayList<Ciudad>();
		acaEstaElLadron = false;
	}

	// SETTERS:
	public void setEdificioCultural(Edificio edificio) {
        this.edificioCultural = edificio;
    }

    public void setEdificioEconomia(Edificio edificio) {
        this.edificioEconomia = edificio;
    }

    public void setEdificioTransporte(Edificio edificio) {
        this.edificioTransporte = edificio;
    }

	public boolean conectarCiudad(Ciudad ciudad) {
        if ( (ciudad != this) && (!this.estaConectadaConEstaCiudad(ciudad)) ) {
			this.ciudadesConectadas.add(ciudad);
        	return true;
        }
        return false;
    }
	
    public boolean estaConectadaConEstaCiudad(Ciudad ciudad) {
        return this.ciudadesConectadas.contains(ciudad);
    }

    public int cantidadDeCiudadesConectadas(){
    	return ciudadesConectadas.size();
    }
	
	public void esconderAlLadron() {
		this.acaEstaElLadron = true;
	}

	//GETTERS:
	public Coordenada getCoordenadas() {
		return this.coordenadas;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public Edificio getEdificioCultural() {
		return this.edificioCultural;
    }

    public Edificio getEdificioEconomia() {
		return this.edificioEconomia;
    }

    public Edificio getEdificioTransporte() {
		return this.edificioTransporte;
    }

    public Edificio getEdificioCultural(Policia policia) throws ExcepcionJugadorSinTiempoDisponible {
        if (this.acaEstaElLadron && enEsteEdificioHiereAlPolicia(this.edificioCultural)) {
			policia.recibirHerida();
		}
		return this.edificioCultural;
    }

    public Edificio getEdificioEconomia(Policia policia) throws ExcepcionJugadorSinTiempoDisponible {
        if (this.acaEstaElLadron && enEsteEdificioHiereAlPolicia(this.edificioEconomia)) {
			policia.recibirHerida();
		}
		return this.edificioEconomia;
    }

    public Edificio getEdificioTransporte(Policia policia) throws ExcepcionJugadorSinTiempoDisponible {
        if (this.acaEstaElLadron && enEsteEdificioHiereAlPolicia(this.edificioTransporte)) {
			policia.recibirHerida();
		}
		return this.edificioTransporte;
    }

    public ArrayList<Ciudad> getCiudadesConectadas() {
        return ciudadesConectadas;
    }

    public boolean escondeAlLadron() {
        return this.acaEstaElLadron;
    }
	
	//PRIVADOS:
	private boolean enEsteEdificioHiereAlPolicia(Edificio edificio) {
		int caracteresNombre = this.nombre.length();
		if (caracteresNombre <= 6 && this.edificioEconomia == edificio) {
			return true;
		} else if (caracteresNombre > 6) {
			if (caracteresNombre % 2 == 0 && this.edificioCultural == edificio) {
				return true;
			}
			else if (this.edificioTransporte == edificio) {
				return true;
			}
		}
		return false;
	}
}

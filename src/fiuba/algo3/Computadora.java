package fiuba.algo3;

import java.util.ArrayList;

public class Computadora {
	Ladron buscado;
	ArrayList<Ladron> sospechosos;
	
	public Computadora(Ladron buscado) {
		this.buscado = buscado;
		sospechosos = new ArrayList();
		sospechosos.add(buscado);
	}
	
	public void setSospechoso(Ladron ladron) {
		sospechosos.add(ladron);
	}
	
	public ArrayList<Ladron> getSospechosos() {
		return sospechosos;
	}
}
package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class IntegradoresTest {
    @Test
    public void calcularTiempoDeViajeCalculaDependiendoDelRangoDelPolicia() {
        Ciudad ciudadSalida = new Ciudad("Buenos Aires", new Coordenada(900.0, 900.0));
        Policia unPolicia = new Policia("Juan", ciudadSalida);
        Ciudad ciudadDestino = new Ciudad("Londres", new Coordenada(900.0, 0.0));
        int tiempoDisponible;

        tiempoDisponible = unPolicia.getTiempoDisponible();
        unPolicia.viajar(ciudadDestino);

        Assert.assertEquals(unPolicia.getTiempoDisponible(), (tiempoDisponible - 1));
    }

    @Test
    public void policiaDeRangoDetectiveObtienePistaNivelIntermedio() {
        Ciudad ciudadSalida = new Ciudad("Buenos Aires", new Coordenada(900.0, 900.0));
        Policia unPolicia = new Policia("Juan", ciudadSalida);
        Rango detective = new Detective();
        Edificio aeropuerto = new Edificio("Aeropuerto");

        aeropuerto.setPistas(new Pista("AF"), new Pista("AI"), new Pista("AD"));
        unPolicia.setRango(detective);
        ciudadSalida.setEdificioSalida(aeropuerto);

        Assert.assertEquals(unPolicia.getRango().pedirPista(aeropuerto), "AI");
    }
	
	public void viajarHastaQueElMetodoDevuelveFalseCuandoSeTerminaElTiempo() {
		Coordenada coordenadaSalida = new Coordenada(-11000.0, -9000.0);
		Ciudad ciudadSalida = new Ciudad("Buenos Aires", coordenadaSalida);
        
		Policia unPolicia = new Policia("Juan", ciudadSalida);
		Rango novato = new Novato();
		unPolicia.setRango(novato);
		
		double valorCoordenada = 2000.0;
		Coordenada coordenadaDestino = new Coordenada(200000.0, 8000.0);
        Ciudad ciudadDestino = new Ciudad("Tokio", coordenadaDestino);
		double distanciaViaje = coordenadaSalida.calcularDistancia(coordenadaDestino);
		int tiempoNecesario = novato.calcularTiempoDeViaje(distanciaViaje);
		while (tiempoNecesario <= unPolicia.getTiempoDisponible()) {
			unPolicia.viajar(ciudadDestino);
			
			coordenadaSalida = coordenadaDestino;
			coordenadaDestino = new Coordenada(valorCoordenada, valorCoordenada);
			valorCoordenada = valorCoordenada*2;
			
			ciudadDestino = new Ciudad("Random", coordenadaDestino);
			
			distanciaViaje = coordenadaSalida.calcularDistancia(coordenadaDestino);
			tiempoNecesario = novato.calcularTiempoDeViaje(distanciaViaje);
		}
		
		Assert.assertFalse(unPolicia.viajar(ciudadDestino));
	}	
}
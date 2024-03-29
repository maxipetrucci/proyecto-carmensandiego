package fiuba.algo3.modelo;

import org.junit.Test;
import junit.framework.Assert;

public class NovatoTest {
    @Test
    public void pedirPistaDevuelveLaPistaDeDificultadFacil() {
        Novato novato = new Novato();
        Edificio edificio = new Edificio();
        Pista pistaFacil = new Pista("PF");

        edificio.setPistas(pistaFacil, new Pista("PI"), new Pista("PD"));

        Assert.assertEquals(novato.pedirPista(edificio), pistaFacil.getPista());
    }

    @Test
    public void calcularTiempoDeViajeCalculaElViajeConLaVelocidadCorrecta() {
        Novato novato = new Novato();

        Assert.assertEquals(novato.calcularTiempoDeViaje(900.0), 1);
    }

    @Test
    public void calcularTiempoDeViajeDevuelve1SiLaDistanciaEsMenoraLaVelocidadDelPolicia() {
        Novato novato = new Novato();

        Assert.assertEquals(novato.calcularTiempoDeViaje(100.0), 1);
    }
	
	@Test
	public void determinarRangoSiguienteDevuelveNullPorqueNoTengoLaCantidadDeCasosNecesarios() {
		Novato novato = new Novato();
		
		Assert.assertNull(novato.determinarRangoSiguiente(0));
	}
	
	@Test
	public void determinarRangoSiguienteDevuelveUnDetectiveSiTengoLaCantidadDeCasosNecesarios() {
		Novato novato = new Novato();
		
		Assert.assertEquals(novato.determinarRangoSiguiente(Novato.CASOS_NECESARIOS_ASCENSO).getClass(), Detective.class);
	}
}

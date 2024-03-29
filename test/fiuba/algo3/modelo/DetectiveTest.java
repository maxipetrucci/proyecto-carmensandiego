package fiuba.algo3.modelo;

import org.junit.Test;
import junit.framework.Assert;

public class DetectiveTest {
    @Test
    public void pedirPistaDevuelveLaPistaDeDificultadIntermedia() {
        Detective detective = new Detective();
        Edificio edificio = new Edificio();
        Pista pistaNivelIntermedia = new Pista("PI");

        edificio.setPistas(new Pista("PF"), pistaNivelIntermedia, new Pista("PD"));

        Assert.assertEquals(detective.pedirPista(edificio), pistaNivelIntermedia.getPista());
    }

    @Test
    public void calcularTiempoDeViajeCalculaElViajeConLaVelocidadCorrecta() {
        Detective detective = new Detective();

        Assert.assertEquals(detective.calcularTiempoDeViaje(1100.0), 1);
    }

    @Test
    public void calcularTiempoDeViajeDevuelve1SiLaDistanciaEsMenoraLaVelocidadDelPolicia() {
        Detective detective = new Detective();

        Assert.assertEquals(detective.calcularTiempoDeViaje(100.0), 1);
    }
	
	@Test
	public void determinarRangoSiguienteDevuelveNullPorqueNoTengoLaCantidadDeCasosNecesarios() {
		Detective detective = new Detective();
		
		Assert.assertNull(detective.determinarRangoSiguiente(0));
	}
	
	@Test
	public void determinarRangoSiguienteDevuelveUnInvestigadorSiTengoLaCantidadDeCasosNecesarios() {
		Detective detective = new Detective();
		
		Assert.assertEquals(detective.determinarRangoSiguiente(Detective.CASOS_NECESARIOS_ASCENSO).getClass(), Investigador.class);
	}
}

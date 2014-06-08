package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class InvestigadorTest {
    @Test
    public void pedirPistaDevuelveLaPistaDeDificultadIntermedia() {
        Investigador investigador = new Investigador();
        Edificio edificio = new Edificio("Aeropuerto");
        Pista pistaNivelIntermedia = new Pista("PI");

        edificio.setPistas(new Pista("PF"), pistaNivelIntermedia, new Pista("PD"));

        Assert.assertEquals(investigador.pedirPista(edificio), pistaNivelIntermedia.getPista());
    }

    @Test
    public void calcularTiempoDeViajeCalculaElViajeConLaVelocidadCorrecta() {
        Investigador investigador = new Investigador();

        Assert.assertEquals(investigador.calcularTiempoDeViaje(1300.0), 1);
    }
}
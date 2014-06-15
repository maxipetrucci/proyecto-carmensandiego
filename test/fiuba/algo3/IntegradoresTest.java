package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class IntegradoresTest {
	@Test
	public void viajarTresPaisesYAtraparLadronConNovato() throws ExcepcionJugadorSinTiempoDisponible {
		Ciudad buenosAires = new Ciudad("Buenos Aires", new Coordenada(-3000.0, -9000.0));
		Ciudad londres = new Ciudad("Londres", new Coordenada(-3000.0, -9000.0));
		Ciudad reykjavic = new Ciudad("Reykjavic", new Coordenada(-3000.0, -9000.0));
		Ciudad tokio = new Ciudad("Tokio", new Coordenada(9000.0, 1500.0));
		Policia unPolicia = new Policia("Esteban", buenosAires);
        Ladron unLadron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
        Computadora computadora = new Computadora(unLadron);

        buenosAires.conectarCiudad(londres);
        londres.conectarCiudad(reykjavic);
        reykjavic.conectarCiudad(tokio);

		unPolicia.visitarEdificioEconomia();
		unPolicia.visitarEdificioCultural();
		unPolicia.visitarEdificioTransporte();
		unPolicia.viajar(londres);
		unPolicia.visitarEdificioEconomia();
		unPolicia.visitarEdificioCultural();
		unPolicia.visitarEdificioTransporte();
		unPolicia.viajar(reykjavic);
		unPolicia.visitarEdificioEconomia();
		unPolicia.visitarEdificioCultural();
		unPolicia.visitarEdificioTransporte();

        unPolicia.emitirOrdenDeArresto(computadora, Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);

		unPolicia.viajar(tokio);
		unPolicia.visitarEdificioCultural();
        unPolicia.visitarEdificioEconomia();
        unPolicia.visitarEdificioTransporte();

		//FALTA COMPLETAR
		
		Assert.assertTrue(true);
	}
}
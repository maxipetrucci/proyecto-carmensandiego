package fiuba.algo3;

import org.junit.Test;
import junit.framework.Assert;

public class IntegradoresTest {
	@Test
	public void viajarTresPaisesYAtraparLadronConNovato() {
		Ciudad buenosAires = new Ciudad("Buenos Aires", new Coordenada(-3000.0, -9000.0));
		Ciudad londres = new Ciudad("Londres", new Coordenada(-3000.0, -9000.0));
		Ciudad reykjavic = new Ciudad("Reykjavic", new Coordenada(-3000.0, -9000.0));
		Ciudad tokio = new Ciudad("Tokio", new Coordenada(9000.0, 1500.0));
		Policia unPolicia = new Policia("Esteban", buenosAires);
		
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
		unPolicia.viajar(tokio);
		
		//FALTA COMPLETAR
		
		Assert.assertTrue(true);
	}
}
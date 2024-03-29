package fiuba.algo3.modelo;

import org.junit.Test;
import junit.framework.Assert;

public class LadronTest {
	@Test
    public void getNombreDevuelveElNombreDelLadron() {
        Ladron ladron = new Ladron("Arturo", Ladron.Sexo.FEMENINO, Ladron.Pelo.MARRON, Ladron.Hobby.CROQUET, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);

        Assert.assertEquals(ladron.getNombre(), "Arturo");
    }

	@Test
	public void tieneEstaCaracteristicaConSexoCorrectoDevuelveTrue() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.FEMENINO, Ladron.Pelo.MARRON, Ladron.Hobby.CROQUET, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertTrue(ladron.tieneEstaCaracteristica(Ladron.Sexo.FEMENINO));
	}
	
	@Test
	public void tieneEstaCaracteristicaConSexoIncorrectoDevuelveFalse() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.CROQUET, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertFalse(ladron.tieneEstaCaracteristica(Ladron.Sexo.FEMENINO));
	}
	
	@Test
	public void tieneEstaCaracteristicaConPeloCorrectoDevuelveTrue() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.FEMENINO, Ladron.Pelo.MARRON, Ladron.Hobby.CROQUET, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertTrue(ladron.tieneEstaCaracteristica(Ladron.Pelo.MARRON));
	}
	
	@Test
	public void tieneEstaCaracteristicaConPeloIncorrectoDevuelveFalse() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.CROQUET, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertFalse(ladron.tieneEstaCaracteristica(Ladron.Pelo.RUBIO));
	}
	
	@Test
	public void tieneEstaCaracteristicaConHobbyCorrectoDevuelveTrue() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.FEMENINO, Ladron.Pelo.MARRON, Ladron.Hobby.CROQUET, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertTrue(ladron.tieneEstaCaracteristica(Ladron.Hobby.CROQUET));
	}
	
	@Test
	public void tieneEstaCaracteristicaConHobbyIncorrectoDevuelveFalse() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertFalse(ladron.tieneEstaCaracteristica(Ladron.Hobby.TENNIS));
	}
	
	@Test
	public void tieneEstaCaracteristicaConAutoCorrectoDevuelveTrue() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.FEMENINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertTrue(ladron.tieneEstaCaracteristica(Ladron.Auto.MOTO));
	}
	
	@Test
	public void tieneEstaCaracteristicaConAutoIncorrectoDevuelveFalse() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertFalse(ladron.tieneEstaCaracteristica(Ladron.Auto.CONVERTIBLE));
	}
	
	@Test
	public void tieneEstaCaracteristicaConMarcaPersonalCorrectoDevuelveTrue() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.FEMENINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertTrue(ladron.tieneEstaCaracteristica(Ladron.MarcaPersonal.TATUAJE));
	}
	
	@Test
	public void tieneEstaCaracteristicaConMarcaPersonalIncorrectoDevuelveFalse() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertFalse(ladron.tieneEstaCaracteristica(Ladron.MarcaPersonal.ANILLO));
	}
	
	@Test
	public void tieneOrdenDeArrestoDevuelveFalseSiNoRecibioArresto() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertFalse(ladron.tieneOrdenDeArresto());
	}
	
	@Test
	public void tieneOrdenDeArrestoDevuelveTrueSiRecibioArresto() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
					
		ladron.recibirOrdenDeArresto();
					
		Assert.assertTrue(ladron.tieneOrdenDeArresto());
	}
	
	@Test
	public void estaArrestadoDevuelveFalseSiNoRecibioArresto() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
								   
		Assert.assertFalse(ladron.estaArrestado());
	}
	
	@Test
	public void estaArrestadoDevuelveTrueSiRecibioArresto() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
					
		ladron.recibirArresto();
					
		Assert.assertTrue(ladron.estaArrestado());
	}
	
	@Test
	public void generarUnaPistaSobreElSexoDevuelveElStringDeSexoMasculino() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
		
		Assert.assertEquals(ladron.generarUnaPistaSobreElSexo(), "masculino");
	}
	
	@Test
	public void generarUnaPistaSobreElPeloDevuelveElStringDePeloMarron() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
		
		Assert.assertEquals(ladron.generarUnaPistaSobreElPelo(), "Tenia el pelo marron");
	}
	
	@Test
	public void generarUnaPistaSobreElHobbyDevuelveElStringDeAlpinismo() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
		
		Assert.assertEquals(ladron.generarUnaPistaSobreElHobby(), "Dijo que era bueno en alpinismo");
	}
	
	@Test
	public void generarUnaPistaSobreElAutoDevuelveElStringDeMoto() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
		
		Assert.assertEquals(ladron.generarUnaPistaSobreElAuto(), "Conducia una moto");
	}
	
	@Test
	public void generarUnaPistaSobreLaMarcaPersonalDevuelveElStringDeTatuaje() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
		
		Assert.assertEquals(ladron.generarUnaPistaSobreLaMarcaPersonal(), "Vi que llevaba un tatuaje");
	}
	
	@Test
	public void resetearUnLadronDejaAlLadronSinOrdenDeArresto() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
		ladron.recibirOrdenDeArresto();
		
		ladron.resetear();
		
		Assert.assertFalse(ladron.tieneOrdenDeArresto());
	}
	
	@Test
	public void resetearUnLadronDejaAlLadronSinArresto() {
		Ladron ladron = new Ladron("Arturo", Ladron.Sexo.MASCULINO, Ladron.Pelo.MARRON, Ladron.Hobby.ALPINISMO, Ladron.Auto.MOTO, Ladron.MarcaPersonal.TATUAJE);
		ladron.recibirArresto();
		
		ladron.resetear();
		
		Assert.assertFalse(ladron.estaArrestado());
	}
}
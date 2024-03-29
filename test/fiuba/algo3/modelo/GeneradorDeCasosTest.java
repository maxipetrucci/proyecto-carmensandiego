package fiuba.algo3.modelo;

import java.util.ArrayList;

import org.junit.Test;
import junit.framework.Assert;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import org.xml.sax.SAXException;

public class GeneradorDeCasosTest {
    @Test
    public void testEstoyLeyendoTodasLasCiudades()
    throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		Assert.assertTrue(generador.estoyLeyendoTodasLasCiudades() == 14);
	}

	@Test
	public void testEstoyLeyendoTodasLasPistasDeUnaCiudad()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		Assert.assertTrue(generador.estoyLeyendoTodasLasPistasDeUnaCiudad() == 9);
	}

	@Test
	public void testEstoyLeyendoElNombreDeLaPrimerCiudad()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		Assert.assertEquals(generador.leoElNombreDeLaPrimerCiudad(), "Atenas");
	}

	@Test
	public void testEstoyLeyendoLaCoordenadaXDeLaPrimerCiudad()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		Assert.assertEquals(generador.leoLaCoordenadaXDeLaPrimerCiudad(), "4500.0");
	}

	@Test
	public void testEstoyLeyendoLaCoordenadaXDeLaPrimerCiudadComoDouble()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		Assert.assertEquals(generador.leoLaCoordenadaXDeLaPrimerCiudadYLaPasoADouble(), 4500.0);
	}

	@Test
	public void testEstoyLeyendoLaCoordenadaYDeLaPrimerCiudad()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		Assert.assertEquals(generador.leoLaCoordenadaYDeLaPrimerCiudad(), "-3540.0");
	}

	@Test
	public void testEstoyLeyendoLaCoordenadaYDeLaPrimerCiudadComoDouble()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		Assert.assertEquals(generador.leoLaCoordenadaYDeLaPrimerCiudadYLaPasoADouble(), -3540.0);
	}

	@Test
	public void testPuedoInstanciarUnaCiudadConElNombre()
	throws ParserConfigurationException, TransformerException, SAXException, IOException, Exception {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		Ciudad ciudadGenerada = generador.puedoInstanciarUnaCiudadConElNombre();

		Assert.assertEquals(ciudadGenerada.getNombre(), "Atenas");
	}

	@Test
    public void seLevantanTodasLasCiudadesDelXML()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();

		ArrayList<Ciudad> ciudades = generador.getCiudades();

		Assert.assertTrue(ciudades.size() == 14);
	}

	@Test
    public void laPrimerCiudadLevantadGuardaElNombreCorrecto()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();

		ArrayList<Ciudad> ciudades = generador.getCiudades();

		Assert.assertEquals(ciudades.get(0).getNombre(), "Atenas");
	}

	@Test
    public void laSegundaCiudadLevantadGuardaElNombreCorrecto()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();

		ArrayList<Ciudad> ciudades = generador.getCiudades();

		Assert.assertEquals(ciudades.get(13).getNombre(), "Paris");
	}

	@Test
    public void seLevantanTodasLasPistasPorCiudadDelXML()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();

		ArrayList<ArrayList<Pista>> pistasDeLasCiudades = generador.getPistasPorCiudad();

		Assert.assertTrue(pistasDeLasCiudades.size() == 14);
	}

	@Test
    public void seLevantanTodasLasPistasDeUnaCiudadDelXML()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();

		ArrayList<ArrayList<Pista>> pistasDeLasCiudades = generador.getPistasPorCiudad();

		ArrayList<Pista> pistasDeUnaCiudad = pistasDeLasCiudades.get(0);

		Assert.assertTrue(pistasDeUnaCiudad.size() == 9);
	}

	@Test
    public void laPrimerPistaDeLaPrimerCiudadDelXMLCoincide()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();

		ArrayList<ArrayList<Pista>> pistasDeLasCiudades = generador.getPistasPorCiudad();

		ArrayList<Pista> pistasDeUnaCiudad = pistasDeLasCiudades.get(0);

		Assert.assertEquals(pistasDeUnaCiudad.get(0).getPista(), "Cambio su dinero a drachmas.");
	}

	@Test
    public void laUltimaPistaDeLaPrimerCiudadDelXMLCoincide()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();

		ArrayList<ArrayList<Pista>> pistasDeLasCiudades = generador.getPistasPorCiudad();

		ArrayList<Pista> pistasDeUnaCiudad = pistasDeLasCiudades.get(0);

		Assert.assertEquals(pistasDeUnaCiudad.get(8).getPista(), "Me pregunto si tenia algun libro sobre restos arqueologicos");
	}

	@Test
    public void laPrimerPistaDeLaUltimaCiudadDelXMLCoincide()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();

		ArrayList<ArrayList<Pista>> pistasDeLasCiudades = generador.getPistasPorCiudad();

		ArrayList<Pista> pistasDeUnaCiudad = pistasDeLasCiudades.get(13);

		Assert.assertEquals(pistasDeUnaCiudad.get(0).getPista(), "Cambio su dinero a Euros.");
	}

	@Test
    public void laUltimaPistaDeLaUltimaCiudadDelXMLCoincide()
	throws ParserConfigurationException, TransformerException, SAXException, IOException {
		GeneradorDeCasos generador = new GeneradorDeCasos();

		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();

		ArrayList<ArrayList<Pista>> pistasDeLasCiudades = generador.getPistasPorCiudad();

		ArrayList<Pista> pistasDeUnaCiudad = pistasDeLasCiudades.get(13);

		Assert.assertEquals(pistasDeUnaCiudad.get(8).getPista(), "Estaba llendo una biblografia de Luis XIV, el rey Sol.");
	}
        
	@Test
    public void generarUnCasoSeteaLaPrimerCiudadConLasPistasDeLaSiguienteParaUnNovato()
    throws ParserConfigurationException, TransformerException, SAXException, IOException{

		GeneradorDeCasos generador = new GeneradorDeCasos();
		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();
		ArrayList<Ciudad> todaslasciudades =generador.getCiudades();
		ArrayList<ArrayList<Pista>> todaslaspistas =generador.getPistasPorCiudad();

		ArrayList<Ciudad> ciudadesPorRecorrer=generador.generarUnCaso();
		Ciudad ciudadInicial= ciudadesPorRecorrer.get(0);
		Edificio edificioEconomico=ciudadInicial.getEdificioEconomia();
		Edificio edificioTransporte=ciudadInicial.getEdificioTransporte();
		Edificio edificioCultural=ciudadInicial.getEdificioCultural();
		Novato novato=new Novato();

		Ciudad ciudadSiguiente= ciudadesPorRecorrer.get(1);
		int indice= todaslasciudades.indexOf(ciudadSiguiente);
		ArrayList<Pista> pistasCiudadSiguiente = todaslaspistas.get(indice);

		Assert.assertFalse("No se nada sobre ese sujeto."==edificioEconomico.getPista(novato));
		Assert.assertFalse("Algo muy raro esta pasando en la ciudad."== edificioEconomico.getPista(novato));

		Assert.assertEquals(pistasCiudadSiguiente.get(0).getPista(), edificioEconomico.getPista(novato));
		Assert.assertEquals(pistasCiudadSiguiente.get(3).getPista(), edificioTransporte.getPista(novato));
		Assert.assertEquals(pistasCiudadSiguiente.get(6).getPista(), edificioCultural.getPista(novato));

	}
        
	@Test
    public void generarUnCasoSeteaUnaCiudadDelMedioConLasPistasDeLaSiguienteParaUnNovato()
    throws ParserConfigurationException, TransformerException, SAXException, IOException{

		GeneradorDeCasos generador = new GeneradorDeCasos();
		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();
		ArrayList<Ciudad> todaslasciudades =generador.getCiudades();
		ArrayList<ArrayList<Pista>> todaslaspistas =generador.getPistasPorCiudad();

		ArrayList<Ciudad> ciudadesPorRecorrer=generador.generarUnCaso();
		Ciudad ciudadInicial= ciudadesPorRecorrer.get(2);
		Edificio edificioEconomico=ciudadInicial.getEdificioEconomia();
		Edificio edificioTransporte=ciudadInicial.getEdificioTransporte();
		Edificio edificioCultural=ciudadInicial.getEdificioCultural();
		Novato novato=new Novato();

		Ciudad ciudadSiguiente= ciudadesPorRecorrer.get(3);
		int indice= todaslasciudades.indexOf(ciudadSiguiente);
		ArrayList<Pista> pistasCiudadSiguiente = todaslaspistas.get(indice);

		Assert.assertFalse("No se nada sobre ese sujeto."==edificioEconomico.getPista(novato));
		Assert.assertFalse("Algo muy raro esta pasando en la ciudad."== edificioEconomico.getPista(novato));

		Assert.assertEquals(pistasCiudadSiguiente.get(0).getPista(), edificioEconomico.getPista(novato));
		Assert.assertEquals(pistasCiudadSiguiente.get(3).getPista(), edificioTransporte.getPista(novato));
		Assert.assertEquals(pistasCiudadSiguiente.get(6).getPista(), edificioCultural.getPista(novato));

	}

	@Test
    public void generarUnCasoSeteaLaUltimaciudadConLasPistaDeQueELLadronEstaCercaParaCualquierPoliciaEnCualquierLugar()
    throws ParserConfigurationException, TransformerException, SAXException, IOException{

		GeneradorDeCasos generador = new GeneradorDeCasos();
		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();
		ArrayList<Ciudad> todaslasciudades =generador.getCiudades();
		ArrayList<ArrayList<Pista>> todaslaspistas =generador.getPistasPorCiudad();

		ArrayList<Ciudad> ciudadesPorRecorrer=generador.generarUnCaso();
		Ciudad ciudadInicial= ciudadesPorRecorrer.get(5);
		Edificio edificioEconomico=ciudadInicial.getEdificioEconomia();
		Edificio edificioTransporte=ciudadInicial.getEdificioTransporte();
		Edificio edificioCultural=ciudadInicial.getEdificioCultural();

		Novato novato=new Novato();
		Investigador investigador=new Investigador();
		Sargento sargento=new Sargento();
		Detective detective=new Detective();


		Assert.assertFalse("No se nada sobre ese sujeto."==edificioEconomico.getPista(novato));

		Assert.assertEquals("Algo muy raro esta pasando en la ciudad.", edificioEconomico.getPista(novato));
		Assert.assertEquals("Algo muy raro esta pasando en la ciudad.", edificioTransporte.getPista(novato));
		Assert.assertEquals("Algo muy raro esta pasando en la ciudad.", edificioCultural.getPista(novato));
		Assert.assertEquals("Algo muy raro esta pasando en la ciudad.", edificioEconomico.getPista(investigador));
		Assert.assertEquals("Algo muy raro esta pasando en la ciudad.", edificioTransporte.getPista(investigador));
		Assert.assertEquals("Algo muy raro esta pasando en la ciudad.", edificioCultural.getPista(investigador));
		Assert.assertEquals("Algo muy raro esta pasando en la ciudad.", edificioEconomico.getPista(sargento));
		Assert.assertEquals("Algo muy raro esta pasando en la ciudad.", edificioTransporte.getPista(sargento));
		Assert.assertEquals("Algo muy raro esta pasando en la ciudad.", edificioCultural.getPista(sargento));
		Assert.assertEquals("Algo muy raro esta pasando en la ciudad.", edificioEconomico.getPista(detective));
		Assert.assertEquals("Algo muy raro esta pasando en la ciudad.", edificioTransporte.getPista(detective));
		Assert.assertEquals("Algo muy raro esta pasando en la ciudad.", edificioCultural.getPista(detective));
        }
        
	@Test
    public void generarUnCasoSeteaUnaCiudadDelMedioConLasPistasDeLaSiguienteParaUnSargento()
    throws ParserConfigurationException, TransformerException, SAXException, IOException{

		GeneradorDeCasos generador = new GeneradorDeCasos();
		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();
		ArrayList<Ciudad> todaslasciudades =generador.getCiudades();
		ArrayList<ArrayList<Pista>> todaslaspistas =generador.getPistasPorCiudad();

		ArrayList<Ciudad> ciudadesPorRecorrer=generador.generarUnCaso();
		Ciudad ciudadInicial= ciudadesPorRecorrer.get(3);
		Edificio edificioEconomico=ciudadInicial.getEdificioEconomia();
		Edificio edificioTransporte=ciudadInicial.getEdificioTransporte();
		Edificio edificioCultural=ciudadInicial.getEdificioCultural();
		Sargento sargento=new Sargento();

		Ciudad ciudadSiguiente= ciudadesPorRecorrer.get(4);
		int indice= todaslasciudades.indexOf(ciudadSiguiente);
		ArrayList<Pista> pistasCiudadSiguiente = todaslaspistas.get(indice);

		Assert.assertFalse("No se nada sobre ese sujeto."==edificioEconomico.getPista(sargento));
		Assert.assertFalse("Algo muy raro esta pasando en la ciudad."== edificioEconomico.getPista(sargento));

		Assert.assertEquals(pistasCiudadSiguiente.get(2).getPista(), edificioEconomico.getPista(sargento));
		Assert.assertEquals(pistasCiudadSiguiente.get(5).getPista(), edificioTransporte.getPista(sargento));
		Assert.assertEquals(pistasCiudadSiguiente.get(8).getPista(), edificioCultural.getPista(sargento));

	}
        
	@Test
    public void generarUnCasoSeteaLaPrimerCiudadConLasPistasDeLaSiguienteParaUnDetective()
    throws ParserConfigurationException, TransformerException, SAXException, IOException{

		GeneradorDeCasos generador = new GeneradorDeCasos();
		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();
		ArrayList<Ciudad> todaslasciudades =generador.getCiudades();
		ArrayList<ArrayList<Pista>> todaslaspistas =generador.getPistasPorCiudad();

		ArrayList<Ciudad> ciudadesPorRecorrer=generador.generarUnCaso();
		Ciudad ciudadInicial= ciudadesPorRecorrer.get(0);
		Edificio edificioEconomico=ciudadInicial.getEdificioEconomia();
		Edificio edificioTransporte=ciudadInicial.getEdificioTransporte();
		Edificio edificioCultural=ciudadInicial.getEdificioCultural();
		Detective detective=new Detective();

		Ciudad ciudadSiguiente= ciudadesPorRecorrer.get(1);
		int indice= todaslasciudades.indexOf(ciudadSiguiente);
		ArrayList<Pista> pistasCiudadSiguiente = todaslaspistas.get(indice);

		Assert.assertFalse("No se nada sobre ese sujeto."==edificioEconomico.getPista(detective));
		Assert.assertFalse("Algo muy raro esta pasando en la ciudad."== edificioEconomico.getPista(detective));

		Assert.assertEquals(pistasCiudadSiguiente.get(1).getPista(), edificioEconomico.getPista(detective));
		Assert.assertEquals(pistasCiudadSiguiente.get(4).getPista(), edificioTransporte.getPista(detective));
		Assert.assertEquals(pistasCiudadSiguiente.get(7).getPista(), edificioCultural.getPista(detective));

	}
        
	@Test
    public void generarUnCasoSeteaUnaCiudadDelMedioConLasPistasDeLaSiguienteParaUnInvestigador()
    throws ParserConfigurationException, TransformerException, SAXException, IOException{

		GeneradorDeCasos generador = new GeneradorDeCasos();
		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();
		ArrayList<Ciudad> todaslasciudades =generador.getCiudades();
		ArrayList<ArrayList<Pista>> todaslaspistas =generador.getPistasPorCiudad();

		ArrayList<Ciudad> ciudadesPorRecorrer=generador.generarUnCaso();
		Ciudad ciudadInicial= ciudadesPorRecorrer.get(4);
		Edificio edificioEconomico=ciudadInicial.getEdificioEconomia();
		Edificio edificioTransporte=ciudadInicial.getEdificioTransporte();
		Edificio edificioCultural=ciudadInicial.getEdificioCultural();
		Investigador investigador= new Investigador();

		Ciudad ciudadSiguiente= ciudadesPorRecorrer.get(5);
		int indice= todaslasciudades.indexOf(ciudadSiguiente);
		ArrayList<Pista> pistasCiudadSiguiente = todaslaspistas.get(indice);

		Assert.assertFalse("No se nada sobre ese sujeto."==edificioEconomico.getPista(investigador));
		Assert.assertFalse("Algo muy raro esta pasando en la ciudad."== edificioEconomico.getPista(investigador));

		Assert.assertEquals(pistasCiudadSiguiente.get(1).getPista(), edificioEconomico.getPista(investigador));
		Assert.assertEquals(pistasCiudadSiguiente.get(4).getPista(), edificioTransporte.getPista(investigador));
		Assert.assertEquals(pistasCiudadSiguiente.get(7).getPista(), edificioCultural.getPista(investigador));
	}
	
	@Test
    public void laPrimeraCiudadDeSetearCiudadesContieneALaCiudadSiguienteDelRecorrido()
    throws ParserConfigurationException, TransformerException, SAXException, IOException{

		GeneradorDeCasos generador = new GeneradorDeCasos();
                
		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();
		ArrayList<Ciudad> todaslasciudades =generador.getCiudades();
		ArrayList<ArrayList<Pista>> todaslaspistas =generador.getPistasPorCiudad();     
		ArrayList<Ciudad> ciudadesPorRecorrer=generador.generarUnCaso();
		Ciudad ciudadActual=ciudadesPorRecorrer.get(0);
		generador.setearCiudadesConectadasPorRecorrer(ciudadActual, ciudadesPorRecorrer);
                
		Assert.assertTrue(ciudadActual.estaConectadaConEstaCiudad(ciudadesPorRecorrer.get(1)));
		Assert.assertEquals(ciudadActual.cantidadDeCiudadesConectadas(), 4);            
	}   
    
	@Test
    public void UnaCiudadDelMedioDeSetearCiudadesContieneALaCiudadSiguienteYALaAnteriorDelRecorrido()
    throws ParserConfigurationException, TransformerException, SAXException, IOException{

		GeneradorDeCasos generador = new GeneradorDeCasos();
                
		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();
		ArrayList<Ciudad> todaslasciudades =generador.getCiudades();
		ArrayList<ArrayList<Pista>> todaslaspistas =generador.getPistasPorCiudad();     
		ArrayList<Ciudad> ciudadesPorRecorrer=generador.generarUnCaso();
		Ciudad ciudadActual=ciudadesPorRecorrer.get(3);
		generador.setearCiudadesConectadasPorRecorrer(ciudadActual, ciudadesPorRecorrer);
                
		Assert.assertTrue(ciudadActual.estaConectadaConEstaCiudad(ciudadesPorRecorrer.get(4)));
		Assert.assertTrue(ciudadActual.estaConectadaConEstaCiudad(ciudadesPorRecorrer.get(2)));
		Assert.assertEquals(ciudadActual.cantidadDeCiudadesConectadas(), 4);    
        }    
		
	@Test
    public void UnaCiudadDelFinalDeSetearCiudadesContieneALaAnteriorDelRecorrido()
    throws ParserConfigurationException, TransformerException, SAXException, IOException{

		GeneradorDeCasos generador = new GeneradorDeCasos();
                
		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();
		ArrayList<Ciudad> todaslasciudades =generador.getCiudades();
		ArrayList<ArrayList<Pista>> todaslaspistas =generador.getPistasPorCiudad();     
		ArrayList<Ciudad> ciudadesPorRecorrer=generador.generarUnCaso();
		Ciudad ciudadActual=ciudadesPorRecorrer.get(5);
		generador.setearCiudadesConectadasPorRecorrer(ciudadActual, ciudadesPorRecorrer);
                
		Assert.assertTrue(ciudadActual.estaConectadaConEstaCiudad(ciudadesPorRecorrer.get(4)));
		Assert.assertEquals(ciudadActual.cantidadDeCiudadesConectadas(), 4);    
        }  
		
	@Test
    public void GenerarCiudadesConectadasCreaUnaListaDeCiudadesDiferenteALaOrignialYNoRepetidas()
    throws ParserConfigurationException, TransformerException, SAXException, IOException{

		GeneradorDeCasos generador = new GeneradorDeCasos();
                
		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();
		ArrayList<Ciudad> todaslasciudades =generador.getCiudades();
		ArrayList<ArrayList<Pista>> todaslaspistas =generador.getPistasPorCiudad();     
		ArrayList<Ciudad> ciudadesPorRecorrer=generador.generarUnCaso();
		Ciudad ciudadActual=ciudadesPorRecorrer.get(3);
		generador.setearCiudadesConectadasPorRecorrer(ciudadActual, ciudadesPorRecorrer);
                
		ArrayList <Ciudad> ciudadesConectadas=ciudadActual.getCiudadesConectadas();
		Assert.assertNotSame(ciudadesConectadas.get(0), ciudadesConectadas.get(1));
		Assert.assertNotSame(ciudadesConectadas.get(1) , ciudadesConectadas.get(2));
		Assert.assertNotSame(ciudadesConectadas.get(2) , ciudadesConectadas.get(3));            
		Assert.assertNotSame(ciudadesConectadas.get(1) , ciudadesConectadas.get(3));
		Assert.assertNotSame(ciudadesConectadas.get(0) , ciudadesConectadas.get(3));                            
		Assert.assertNotSame(ciudadesConectadas.get(0) , ciudadesConectadas.get(2));    
                
		Assert.assertNotSame(ciudadesConectadas.get(0) , ciudadActual);
		Assert.assertNotSame(ciudadesConectadas.get(1) , ciudadActual);
		Assert.assertNotSame(ciudadesConectadas.get(2) , ciudadActual);         
		Assert.assertNotSame(ciudadesConectadas.get(3), ciudadActual);                  
                
	}
	
	@Test
    public void elCasoGeneradoDeterminaUnaCiudadDondeSeHiereAlPolicia()
    throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionTiempoAgotado {

		GeneradorDeCasos generador = new GeneradorDeCasos();
		generador.leerXMLDeCiudadesEInstanciarCadaCiudadYSusPistas();
   
		ArrayList<Ciudad> ciudadesPorRecorrer = generador.generarUnCaso();
		
		Ciudad ciudadDondeSeSuponeQueHierenAlPolicia = ciudadesPorRecorrer.get(GeneradorDeCasos.NUMERO_CIUDAD_HIERE_POLICIA);
		
		Policia policiaDePrueba = new Policia("Alberto");
		
		String pistaCultural = ciudadDondeSeSuponeQueHierenAlPolicia.recibirVisitaEdificioCultural(policiaDePrueba);
		String pistaEconomia = ciudadDondeSeSuponeQueHierenAlPolicia.recibirVisitaEdificioEconomia(policiaDePrueba);
		String pistaTransporte = ciudadDondeSeSuponeQueHierenAlPolicia.recibirVisitaEdificioTransporte(policiaDePrueba);
		
		boolean hirioEnCultural = pistaCultural == Ciudad.MENSAJE_RECIBE_HERIDA;
		boolean hirioEnEconomia = pistaEconomia == Ciudad.MENSAJE_RECIBE_HERIDA;
		boolean hirioEnTransporte = pistaTransporte == Ciudad.MENSAJE_RECIBE_HERIDA;
		
		Assert.assertTrue(hirioEnCultural || hirioEnEconomia || hirioEnTransporte);
	}
}
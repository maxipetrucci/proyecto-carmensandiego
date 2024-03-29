package fiuba.algo3;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.Ladron;
import fiuba.algo3.modelo.ExcepcionTiempoAgotado;

public class Controlador {

	private Scanner scan;
	private Juego juego;
	private Vista vista;

	Controlador (Juego juego) {
		this.scan = new Scanner(System.in);
		this.juego = juego;
	}

	public int pedirOpcion() {
		return this.scan.nextInt();
	}

	public void setVista(Vista vista) {
		this.vista = vista;
	}

	/********************************************************************************/
	/*                        ***       PRINCIPALES       ***                       */
	/********************************************************************************/
	public void iniciar() {
		this.vista.mostrarPantallaBienvenida();
		boolean quiereJugar = preguntarSiJuega();
		if (quiereJugar) {
			this.vista.mostrarPedidoDeNombre();
			registrarNombreJugador();
		}

		while (quiereJugar) {

			this.vista.mostrarPresentacionDelCaso();
			iniciarPartida();
			this.vista.mostrarJugarDeNuevo();
			quiereJugar = preguntarSiJuega();
		}

		juego.cerrar();
	}

	private void registrarNombreJugador() {

		String nombre = "";
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			nombre = entrada.readLine();
			}
		catch (IOException e) {}

		juego.ingresarNombreJugador(nombre);

	}

	public void iniciarPartida() {
		boolean tiempoAgotado = false;
		while (!this.juego.encontreAlLadron() && !tiempoAgotado) {
			this.vista.mostrarMenuPrincipal();
			try {
				pedirOpcionMenuPrincipal();
			} catch (ExcepcionTiempoAgotado e) {
				this.vista.mostrarElJugadorSeQuedoSinTiempo();
				tiempoAgotado = true;
			}
		}
		if (!tiempoAgotado) {
			resultadoDeArrestarAlLadron();
		}
	}

	private void pedirOpcionMenuPrincipal() throws ExcepcionTiempoAgotado {
		int opcion = pedirOpcion();

		if (opcion == 1) {
			this.vista.mostrarOpcionPista();
			pedirOpcionPista();
		}
		else if (opcion == 2) {
			this.vista.mostrarOpcionViajar();
			pedirOpcionViajar();
		}
		else if (opcion == 3) {
			this.vista.mostrarOpcionComputadora();
			pedirOpcionComputadora();
		}
		else if (opcion == 0) {
			this.juego.cerrar();
		}
	}

	private void resultadoDeArrestarAlLadron() {
		if (!juego.ordenDeArrestoEmitida()) {
			this.vista.mostrarErrorOrdenDeArrestoNoEmitida();
		}
		else if (this.juego.elLadronBuscadoFueArrestado()) {
			this.vista.mostrarResultadoAtrapoAlLadronCorrecto();
			if (juego.elPoliciaRecibioAscenso()) {
				vista.imprimirMensajeDeAscenso();
			}
		}
		else {
			this.vista.mostrarResultadoAtrapoAlLadronIncorrecto();
		}
	}

	private boolean preguntarSiJuega() {
		int opcion = pedirOpcion();

		if (opcion == 1) {
			this.juego.crearPartida();
			return true;
		}
		else {
			return false;
		}
	}

	/********************************************************************************/
	/*                ***       INTERACTUAR CON COMPUTADORA       ***               */
	/********************************************************************************/
	public void pedirOpcionComputadora() {
		int opcion = pedirOpcion();
		if (opcion == 1) {
			this.vista.mostrarOpcionFiltrar();
			pedirOpcionFiltrar();
		}
		else if (opcion == 2) {
			pedirOpcionOrdenDeArresto();
		}
	}

	public void pedirOpcionOrdenDeArresto() {
		String nombreDelLadron = juego.emitirOrdenDeArresto();
		if (nombreDelLadron != "") {
			this.vista.mostrarOrdenDeArrestoEmitida(nombreDelLadron);
		}
		else {
			this.vista.mostrarOrdenDeArrestoNoEmitida();
		}
	}

	public void pedirOpcionFiltrar() {
		int opcion = pedirOpcion();

		if (opcion == 1) {
			this.vista.mostrarOpcionFiltrarSexo();
			pedirOpcionFiltrarSexo();
		}
		else if (opcion == 2) {
			this.vista.mostrarOpcionFiltrarPelo();
			pedirOpcionFiltrarPelo();
		}
		else if (opcion == 3) {
			this.vista.mostrarOpcionFiltrarHobby();
			pedirOpcionFiltrarHobby();
		}
		else if (opcion == 4) {
			this.vista.mostrarOpcionFiltrarAuto();
			pedirOpcionFiltrarAuto();
		}
		else if (opcion == 5) {
			this.vista.mostrarOpcionFiltrarMarcaPersonal();
			pedirOpcionFiltrarMarcaPersonal();
		}
	}

	private void pedirOpcionFiltrarMarcaPersonal() {
 		int opcion = pedirOpcion();

 		if (opcion == 1) {
 			this.juego.ingresarCaracteristicaDelLadron(Ladron.MarcaPersonal.ANILLO);
 		}
 		else if (opcion == 2) {
 			this.juego.ingresarCaracteristicaDelLadron(Ladron.MarcaPersonal.CICATRIZ);
 		}
 		else if (opcion == 3)  {
 			this.juego.ingresarCaracteristicaDelLadron(Ladron.MarcaPersonal.TATUAJE);
 		}
	}

	private void pedirOpcionFiltrarAuto() {
		int opcion = pedirOpcion();

		if (opcion == 1) {
			this.juego.ingresarCaracteristicaDelLadron(Ladron.Auto.CONVERTIBLE);
		}
		else if (opcion == 2) {
			this.juego.ingresarCaracteristicaDelLadron(Ladron.Auto.LIMUSINA);
		}
		else if (opcion == 3) {
			this.juego.ingresarCaracteristicaDelLadron(Ladron.Auto.MOTO);
		}
	}

	private void pedirOpcionFiltrarHobby() {
		int opcion = pedirOpcion();

		if (opcion == 1) {
			this.juego.ingresarCaracteristicaDelLadron(Ladron.Hobby.ALPINISMO);
		}
		else if (opcion == 2) {
			this.juego.ingresarCaracteristicaDelLadron(Ladron.Hobby.CROQUET);
		}
		else if (opcion == 3) {
			this.juego.ingresarCaracteristicaDelLadron(Ladron.Hobby.TENNIS);
		}
	}

	private void pedirOpcionFiltrarPelo() {
		int opcion = pedirOpcion();

		if (opcion == 1){
			this.juego.ingresarCaracteristicaDelLadron(Ladron.Pelo.NEGRO);
		}
		else if (opcion == 2){
			this.juego.ingresarCaracteristicaDelLadron(Ladron.Pelo.RUBIO);
		}
		else if (opcion == 3){
			this.juego.ingresarCaracteristicaDelLadron(Ladron.Pelo.ROJO);
		}
		else if (opcion == 4){
			this.juego.ingresarCaracteristicaDelLadron(Ladron.Pelo.MARRON);
		}
	}

	private void pedirOpcionFiltrarSexo() {
		int opcion = pedirOpcion();

		if (opcion == 1) {
			this.juego.ingresarCaracteristicaDelLadron(Ladron.Sexo.MASCULINO);
		}
		else if (opcion == 2) {
			this.juego.ingresarCaracteristicaDelLadron(Ladron.Sexo.FEMENINO);
		}
	}

	/********************************************************************************/
	/*                  ***       INTERACTUAR CON POLICIA       ***                 */
	/********************************************************************************/
	public void pedirOpcionPista() throws ExcepcionTiempoAgotado {
		int opcion = pedirOpcion();

		if (opcion == 1) {
			this.vista.imprimirPista(juego.verPistaEconomia());
		}
		else if (opcion == 2) {
			this.vista.imprimirPista(juego.verPistaTransporte());
		}
		else if (opcion == 3) {
			this.vista.imprimirPista(juego.verPistaCultural());
		}
	}

	public void pedirOpcionViajar() throws ExcepcionTiempoAgotado {
		int opcion = pedirOpcion();

		ArrayList<String> nombreCiudades = this.juego.obtenerNombreDeLasCiudadesALasQuePuedoIr();
		if (opcion != 0) {
			this.juego.viajar(nombreCiudades.get(opcion-1));
		}
	}
}

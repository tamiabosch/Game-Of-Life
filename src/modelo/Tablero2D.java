package modelo;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class Tablero2D extends Tablero {
	
	/**
	 * HashMap with coordenadas as key an Estado Celdas as value
	 */
	//protected HashMap<Coordenada, EstadoCelda> celdas;
	
	public Tablero2D(int ancho, int alto) throws ExcepcionCoordenadaIncorrecta {
		super(new Coordenada2D(ancho, alto));
		//celdas = new HashMap<Coordenada, EstadoCelda>();
		
	}
	
	@Override
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion)  throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero, ExcepcionEjecucion {
		return null;
	}
}

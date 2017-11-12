package modelo;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class Tablero2D.
 */
public class Tablero2D extends Tablero {
	
	/**
	 * HashMap with coordenadas as key an Estado Celdas as value
	 */
	//protected HashMap<Coordenada, EstadoCelda> celdas;
	
	public Tablero2D(int ancho, int alto) throws ExcepcionCoordenadaIncorrecta, ExcepcionEjecucion {
		super(new Coordenada2D(ancho, alto));
		for (int i = 0; i < dimensiones.getX(); i++) {
			for (int j = 0; j < dimensiones.getY(); j++) {
				Coordenada coordenada;
				try {
					coordenada = new Coordenada2D(i,j);
					celdas.put(coordenada, EstadoCelda.MUERTA);
				} catch (ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
			}
		}
	}
	
	/**
	 * empty method for getting posicion vecinas
	 */
	@Override
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion)  throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero, ExcepcionEjecucion {
		return null;
	}
}

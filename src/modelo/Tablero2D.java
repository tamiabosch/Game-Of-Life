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
	 * dimension casted into Coordenada2D
	 */
	protected Coordenada2D dim2D;
	
	/**
	 * Instantiates a new tablero 2 D.
	 *
	 * @param ancho the ancho
	 * @param alto the alto
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionEjecucion the excepcion ejecucion
	 */
	public Tablero2D(int ancho, int alto) throws ExcepcionCoordenadaIncorrecta, ExcepcionEjecucion {
		super(new Coordenada2D(ancho, alto));
		this.dim2D  = (Coordenada2D) dimensiones;
		for (int i = 0; i < dim2D.getX(); i++) {
			for (int j = 0; j < dim2D.getY(); j++) {
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
	 * @return ArrayList<Coordenada>
	 * @throws ExcepcionArgumentosIncorrectos
	 * @throws ExcepcionPosicionFueraTablero
	 * @throws ExcepcionEjecucion
	 */
	@Override
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion)  throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero, ExcepcionEjecucion {
		return null;
	}
}

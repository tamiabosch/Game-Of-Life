/**
 * 
 */
package modelo;

import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * The Class Coordenada.
 *
 * @author Tamia
 * abstract Coordenada class
 */
public abstract class Coordenada {
	
	/**
	 * Instantiates a new coordenada.
	 */
	public Coordenada() {}
	
	/**
	 * sums to coordenadas.
	 *
	 * @param otra the otra
	 * @return the coordenada
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public abstract Coordenada suma(Coordenada otra) throws ExcepcionCoordenadaIncorrecta;

}

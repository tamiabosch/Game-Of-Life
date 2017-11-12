/**
 * 
 */
package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * @author Tami
 *abstract Coordenada class
 */
public abstract class Coordenada {
	
	/**
	 * Instantiates a new coordenada.
	 */
	public Coordenada() {}
	
	/**
	 * sums to coordenadas
	 *
	 * @param otra the otra
	 * @return the coordenada
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public abstract Coordenada suma(Coordenada otra) throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta;
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public abstract int getX();
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public abstract int getY();

}

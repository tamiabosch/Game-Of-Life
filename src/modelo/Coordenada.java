/**
 * 
 */
package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * @author Tami
 *
 */
public abstract class Coordenada {
	
	public Coordenada() {}
	
	public abstract Coordenada suma(Coordenada otra) throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta;
	
	public abstract int getX();
	
	public abstract int getY();

}

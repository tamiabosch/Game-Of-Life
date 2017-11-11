/**
 * 
 */
package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * @author Tami
 *
 */
public abstract class Regla {
	public Regla() {
		
	}
	
	public abstract EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero;
}

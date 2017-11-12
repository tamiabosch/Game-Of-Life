/**
 * 
 */
package modelo;

import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * abstract class Regla
 * @author Tami
 */
public abstract class Regla {
	
	/**
	 * Instantiates a new regla.
	 */
	public Regla() {
		
	}
	
	/**
	 * Calcula siguiente estado celda.
	 *
	 * @param tablero the tablero
	 * @param posicion the posicion
	 * @return the estado celda
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public abstract EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion) throws ExcepcionPosicionFueraTablero;
}

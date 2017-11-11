/**
 * 
 */
package modelo.excepciones;

import modelo.Coordenada;

/**
 * @author Tami
 *
 */
public class ExcepcionPosicionFueraTablero extends Exception {
	
	/** The dimensiones. */
	private Coordenada dimensiones;
	
	/** The coordenada. */
	private Coordenada coordenada;
	
	/**
	 * Instantiates a new excepcion posicion fuera tablero.
	 *
	 * @param dimensiones the dimensiones
	 * @param coorrdenada the coorrdenada
	 */
	public ExcepcionPosicionFueraTablero(Coordenada dimensiones, Coordenada coorrdenada) {
		this.dimensiones = dimensiones;
		this.coordenada = coorrdenada;
	}
	

	/**
	 * prints out Error Message
	 */
	public String getMessage() {
		return" ExcepcionPosicionFueraTablero: \n"
				+ "The tablero has the size "+ dimensiones.getX() +"x" + dimensiones.getY()
						+ " but the Coordenada is at (" + coordenada.getX() + ","+ coordenada.getY()  +")";
	}

	/**
	 * @return the dimensiones
	 */
	public Coordenada getDimensiones() {
		return dimensiones;
	}

	/**
	 * @return the coordenada
	 */
	public Coordenada getCoordenada() {
		return coordenada;
	}
	
	
}

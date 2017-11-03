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
	private Coordenada dimensiones;
	private Coordenada coordenada;
	
	public ExcepcionPosicionFueraTablero(Coordenada dimensiones, Coordenada coorrdenada) {
		this.dimensiones = dimensiones;
		this.coordenada = coorrdenada;
	}
	
	//TODO: gscheide nachricht
	public String getMessages() {
		return"Error in: ExcepcionPosicionFueraTablero \n "
				+ "The tablero has the size "+ dimensiones.getX() +"x" + dimensiones.getY()
						+ "\n but the Coordenada is at (" + coordenada.getX() + ","+ coordenada.getY()  +")";
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

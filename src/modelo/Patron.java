package modelo;

import java.util.Collection;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * creates a pattern which you can put into the juego.
 *
 * @author Tamia Bosch
 */
public class Patron {
	
	/** Name of Patron. */
	private String nombre;
	
	/** the tablero of patron. */
	private Tablero tablero;
	
	/**
	 * Constructor for Patron with:.
	 *
	 * @param nombre name of Patron
	 * @param tablero the tablero
	 */
	public Patron (String nombre, Tablero tablero) {
		if(nombre != null && tablero != null) {
			this.nombre = nombre;
			this.tablero = tablero;
		} else {
			if (nombre==null) {
				throw new ExcepcionArgumentosIncorrectos("Nombre is null, while creating a Patron");

			} else if (tablero==null) {
				throw new ExcepcionArgumentosIncorrectos("Tablero is null, while creating a Patron");

			} else {
				throw new ExcepcionArgumentosIncorrectos("Nombre or Tablero is null, while creating a Patron");

			}
		}
	}
	
	/**
	 * Overrides the toString() method and gives back a representation of the current pattern.
	 *
	 * @return name + the tablero of the cells
	 */
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += this.nombre + "\n";
		toReturn += tablero.toString();
		return toReturn;	
	}

	/**
	 * getter for the status of cells.
	 *
	 * @param posicion Coordenada
	 * @return Estado of the celdas
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public EstadoCelda getCelda(Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		if(posicion != null) {
			if(!tablero.contiene(posicion)) {
				throw new ExcepcionPosicionFueraTablero(tablero.getDimensiones(), posicion);
			} else {
				return this.tablero.getCelda(posicion);			}
		} else {
			throw new ExcepcionArgumentosIncorrectos("Coordenada posicion is null!");
		}
	}
	
	/**
	 * String of the name of patron.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * getter for the tablero of the patron.
	 *
	 * @return tablero
	 */
	public Tablero getTablero() {
		return tablero;
	}
	
	/**
	 * getter for all the posiciones saved in a Collection.
	 *
	 * @return posiciones in a collection
	 */
	public Collection<Coordenada> getPosiciones() {
		return this.tablero.getPosiciones();
	}
	
}

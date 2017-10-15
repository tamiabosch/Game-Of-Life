package modelo;

import java.util.Collection;

/**
 * creates a pattern which you can put into the juego
 * @author Tamia Bosch
 */
public class Patron {
	/**
	 * Name of Patron
	 */
	private String nombre;
	/**
	 * the tablero of patron
	 */
	private Tablero tablero;
	
	/**
	 * Constructor for Patron with:
	 * @param nombre name of Patron
	 * @param tablero 
	 */
	public Patron (String nombre, Tablero tablero) {
		this.nombre = nombre;
		this.tablero = tablero;
	}
	
	/**
	 * Overrides the toString() method and gives back a representation of the current pattern
	 * @return name + the tablero of the cells 
	 */
	@Override
	public String toString() {
		String result = "";
		int sizeX = tablero.getDimensiones().getX();
		int sizeY = tablero.getDimensiones().getY();
		for(int j = 0; j <= sizeY+1; j++) {
			for (int i = 0; i <= sizeX+1; i++) {
				if (i==0 && j == 0 || i == sizeX+1 && j == 0 || i == 0 && j == sizeY+1 || i == sizeX+1 && j == sizeY+1) {
					result += "+"; 
					if (i == sizeX+1){
					result += "\n";	
					}
				} else if (j == 0 || j == sizeY+1) {
					result += "-";
				}else if (i == 0 || i == sizeX+1) {
					result += "|";
					if (i == sizeX+1) {
						result += "\n";
					}
				} else if (this.getCelda(new Coordenada(i-1,j-1)) == EstadoCelda.MUERTA) {
					result += " ";
				}else if (this.getCelda(new Coordenada(i-1,j-1)) == EstadoCelda.VIVA) {
					result += "*";
				}
			}
		}
		return nombre + "\n" + result;
	}

	/**
	 * getter for the status of cells
	 * @param posicion
	 * @return Estado of the celdas
	 */
	public EstadoCelda getCelda(Coordenada posicion) {
		return this.tablero.getCelda(posicion);
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * getter for the tablero of the patron
	 * @return tablero
	 */
	public Tablero getTablero() {
		return tablero;
	}
	
	/**
	 * getter for all the posiciones saved in a Collection
	 * @return posiciones in a collection
	 */
	public Collection<Coordenada> getPosiciones() {
		return this.tablero.getPosiciones();
	}
	
	
}

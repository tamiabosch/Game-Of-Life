package modelo;

import java.util.Collection;

public class Patron {
	private String nombre;
	private Tablero tablero;
	
	public Patron (String nombre, Tablero tablero) {
		this.nombre = nombre;
		this.tablero = tablero;
	}
	
	public EstadoCelda getCelda(Coordenada posicion) {
		return this.tablero.getCelda(posicion);
	}
	
	public Collection<Coordenada> getPosiciones() {
		return this.tablero.getPosiciones();
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	public Tablero getTablero() {
		return tablero;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = "";
		int sizeX = tablero.getDimensiones().getX();
		int sizeY = tablero.getDimensiones().getY();
		for(int i = 0; i < sizeX+2; i++) {
			for (int j = 0; i < sizeY+2; j++) {
				if (i==0 && j == 0 || i == sizeX+2 && j == 0 || i == 0 && j == sizeY+2 || i == sizeX+2 && j == sizeY+2) {
					result += "+"; 
				} else if (j == 0 || j == sizeY+2) {
					result = "-";
				}else if (i == 0 || i == sizeX+2) {
					result = "|";
				} else if (this.getCelda(new Coordenada(i+1,j+1)) == EstadoCelda.MUERTA) {
					result += " ";
				}else if (this.getCelda(new Coordenada(i+1,j+1)) == EstadoCelda.VIVA) {
					result += "*";
				}
			}
		}
		return nombre + "\n " + result;
	}
	
	
}

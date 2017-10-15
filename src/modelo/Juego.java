package modelo;

import java.util.ArrayList;

public class Juego {
	/**
	 * Juego has a Tablero
	 */
	private Tablero tablero;
	/**
	 * the rules for the Juego
	 */
	private ReglaConway regla;
	
	private ArrayList<Patron> patronesUsados = new ArrayList<Patron>();
	
	public Juego(Tablero tablero, ReglaConway regla) {
		this.tablero = tablero;
		this.regla = regla;
	}
	
	public void cargaPatron(Patron p, Coordenada posicionInicial) {
		
	}
	
}

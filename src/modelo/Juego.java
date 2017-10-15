package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Juego {
	/**
	 * Juego has a Tablero
	 */
	private Tablero tablero;
	/**
	 * the rules for the Juego
	 */
	private ReglaConway regla;
	/**
	 * Arraylist with all patrones which are in the game
	 */
	private ArrayList<Patron> patronesUsados = new ArrayList<Patron>();
	
	
	/**
	 * Constructor for Juego with a tablero and regla
	 * @param tablero
	 * @param regla
	 */
	public Juego(Tablero tablero, ReglaConway regla) {
		this.tablero = tablero;
		this.regla = regla;
	}
	
	/**
	 * Tries to load the pattern and store it on patronesUsados
	 * @param p Patron
	 * @param posicionInicial Coordenada
	 */
	public void cargaPatron(Patron p, Coordenada posicionInicial) {
		if(tablero.cargaPatron(p, posicionInicial)) {
			patronesUsados.add(p);
			int startX = posicionInicial.getX();
			int startY = posicionInicial.getY();
			int endX = p.getTablero().getDimensiones().getX() + startX;
			int endY = p.getTablero().getDimensiones().getY() + startY;
			for(int i = startX; i < endX; i++) {
				for (int j = startY; j < endY; j++) {
					tablero.setCelda(new Coordenada(i, j), p.getCelda(new Coordenada(i-startX, j-startY)));
				}
			}
		
		} else {
			System.err.println("Error cargando plantilla " + p.getNombre() + " en (" + tablero.getNotFittingC().getX() + "," + tablero.getNotFittingC().getY() + ")");
		}
	}
	
	/**
	 * calcuates the new state of the juego and all it's celdas
	 */
	public void actualiza() {
		HashMap<Coordenada, EstadoCelda> evolution = new HashMap<Coordenada, EstadoCelda>();
		for( int i = 0; i < tablero.getDimensiones().getX(); i++) {
			for( int j = 1; j < tablero.getDimensiones().getY(); j++ ) {
				Coordenada newCoordenada = new Coordenada (i,j);
				EstadoCelda newEstado = regla.calculaSiguienteEstadoCelda(tablero, newCoordenada);
				evolution.put(newCoordenada, newEstado);
			}
		}
		Collection<Coordenada> collection = tablero.getPosiciones();
		for(int i=0; i < collection.size(); i++) {
			tablero.setCelda((Coordenada) collection.toArray()[i], evolution.get(collection.toArray()[i]));
		}
		
	}

	/**
	 * @return the tablero
	 */
	public Tablero getTablero() {
		return tablero;
	}

	/**
	 * @return the patronesUsados
	 */
	public ArrayList<Patron> getPatrones() {
		return patronesUsados;
	}
}

/**
 * package modelo
 */
package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * Class Juego with a tablero and reglaConway
 * @author Tami
 *
 */
public class Juego {
	/**
	 * Juego has a Tablero
	 */
	private Tablero tablero;
	/**
	 * the rules for the Juego
	 */
	private Regla regla;
	/**
	 * Arraylist with all patrones which are in the game
	 */
	private ArrayList<Patron> patronesUsados = new ArrayList<Patron>();
	
	
	/**
	 * Constructor for Juego with a tablero and regla
	 * @param tablero
	 * @param regla
	 */
	public Juego(Tablero tablero, Regla regla) throws ExcepcionArgumentosIncorrectos{
		if(tablero != null && regla != null) {
			this.tablero = tablero;
			this.regla = regla;
		} else {
			throw new ExcepcionArgumentosIncorrectos("The tablero or regla is null in the Juego class");
		}
	}
	
	/**
	 * Tries to load the pattern and store it on patronesUsados
	 * @param p Patron
	 * @param posicionInicial Coordenada
	 * @throws ExcepcionPosicionFueraTablero 
	 * @throws ExcepcionCoordenadaIncorrecta 
	 * @throws ExcepcionArgumentosIncorrectos 
	 */
	public void cargaPatron(Patron p, Coordenada posicionInicial) throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos, ExcepcionEjecucion {
		if(p != null && posicionInicial != null) {
			tablero.cargaPatron(p, posicionInicial);
			patronesUsados.add(p);
		}  else {
			throw new ExcepcionArgumentosIncorrectos("Patron or CoordenadaInicial is null in Juego!");	
		}
	}
	
	/**
	 * calcuates the new state of the juego and all it's celdas
	 * @throws ExcepcionCoordenadaIncorrecta 
	 */
	public void actualiza() throws ExcepcionEjecucion {
		try {
			HashMap<Coordenada, EstadoCelda> evolution = new HashMap<Coordenada, EstadoCelda>();
			if (tablero instanceof Tablero1D) {
				for( int i = 0; i < tablero.getDimensiones().getX(); i++) {
					Coordenada newCoordenada = new Coordenada1D(i);
					EstadoCelda newEstado = regla.calculaSiguienteEstadoCelda(tablero, newCoordenada);
					evolution.put(newCoordenada, newEstado);
				}
			} else {
				for( int i = 0; i < tablero.getDimensiones().getX(); i++) {
					for( int j = 0; j < tablero.getDimensiones().getY(); j++ ) {
						Coordenada newCoordenada = new Coordenada2D(i,j);
						EstadoCelda newEstado = regla.calculaSiguienteEstadoCelda(tablero, newCoordenada);
						evolution.put(newCoordenada, newEstado);
					}
				}
			}
			Collection<Coordenada> collection = tablero.getPosiciones();
			for(int i=0; i < collection.size(); i++) {
				tablero.setCelda((Coordenada) collection.toArray()[i], evolution.get(collection.toArray()[i]));
			}
		} catch (ExcepcionPosicionFueraTablero e) {
			throw new ExcepcionEjecucion(e);
		} catch (ExcepcionCoordenadaIncorrecta e) {
			throw new ExcepcionEjecucion(e);
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

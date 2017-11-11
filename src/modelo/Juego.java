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
	public Juego(Tablero tablero, Regla regla) {
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
	public void cargaPatron(Patron p, Coordenada posicionInicial) throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta {
		if(p != null && posicionInicial != null) {
			//altes if statment tablero.cargaPatron(p, posicionInicial)
			//Values to check of the patron fits into the tablero
			Coordenada lastCoordenada = tablero.getDimensiones();
			int xSumaCoordenada = posicionInicial.suma(lastCoordenada).getX();
			int ySumaCoordenada = posicionInicial.suma(lastCoordenada).getY();
			int xCoordenadaDim = tablero.getDimensiones().getX();		//wahrscheinlich dim des juegos benutzten!!!
			int yCoordenadaDim = tablero.getDimensiones().getY();
			if(posicionInicial.getX() >= 0 || posicionInicial.getY() >= 0 || (xSumaCoordenada  <= xCoordenadaDim && ySumaCoordenada <= yCoordenadaDim)) {
				patronesUsados.add(p);
				tablero.cargaPatron(p, posicionInicial);
			
			} else {
				throw new ExcepcionPosicionFueraTablero(tablero.getDimensiones(), posicionInicial);
				//System.err.println("Error cargando plantilla " + p.getNombre() + " en (" + tablero.getNotFittingC().getX() + "," + tablero.getNotFittingC().getY() + ")");
			}
		} else {
			throw new ExcepcionArgumentosIncorrectos("Patron or CoordenadaInicial is null in Juego!");
		}
	}
	
	/**
	 * calcuates the new state of the juego and all it's celdas
	 * @throws ExcepcionCoordenadaIncorrecta 
	 */
	public void actualiza() throws ExcepcionCoordenadaIncorrecta {
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

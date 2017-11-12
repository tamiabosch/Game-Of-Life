package modelo;

import java.util.ArrayList;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class Regla30 which extends the abstract class Regla
 * @author Tamia Bosch
 */
public class Regla30 extends Regla {

	/**
	 * Instantiates a new regla 30
	 */
	public Regla30() {
		
	}
	
	/**
	 * Calculates the state of the celdas depending on it's neighbours
	 *
	 * @param tablero the tablero
	 * @param posicion the posicion
	 * @return the estado celda
	 * @throws ExcepcionArgumentosIncorrectos 
	 */
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero {
		if(tablero != null && posicion != null) {
			try {
				ArrayList<Coordenada> vecinas = tablero.getPosicionesVecinasCCW(posicion);
				
				if (vecinas.size() < 2) {
					return EstadoCelda.MUERTA;
				}
				
				Coordenada leftNeighbor = vecinas.get(0);
				Coordenada rightNeighbor = vecinas.get(1);
				
				if (tablero.getCelda(posicion) == EstadoCelda.VIVA && tablero.getCelda(leftNeighbor) == EstadoCelda.VIVA && tablero.getCelda(rightNeighbor) == EstadoCelda.VIVA) { 
					return EstadoCelda.MUERTA; // 111
				} else if (tablero.getCelda(posicion) == EstadoCelda.VIVA && tablero.getCelda(leftNeighbor) == EstadoCelda.VIVA && tablero.getCelda(rightNeighbor) == EstadoCelda.MUERTA) {
					return EstadoCelda.MUERTA; // 110
				} else if (tablero.getCelda(posicion) == EstadoCelda.MUERTA && tablero.getCelda(leftNeighbor) == EstadoCelda.VIVA && tablero.getCelda(rightNeighbor) == EstadoCelda.VIVA) {
					return EstadoCelda.MUERTA; // 101
				} else if (tablero.getCelda(posicion) == EstadoCelda.MUERTA && tablero.getCelda(leftNeighbor) == EstadoCelda.VIVA && tablero.getCelda(rightNeighbor) == EstadoCelda.MUERTA) {
					return EstadoCelda.VIVA; // 100
				} else if (tablero.getCelda(posicion) == EstadoCelda.VIVA && tablero.getCelda(leftNeighbor) == EstadoCelda.MUERTA && tablero.getCelda(rightNeighbor) == EstadoCelda.VIVA) {
					return EstadoCelda.VIVA; // 011
				} else if (tablero.getCelda(posicion) == EstadoCelda.VIVA && tablero.getCelda(leftNeighbor) == EstadoCelda.MUERTA && tablero.getCelda(rightNeighbor) == EstadoCelda.MUERTA) {
					return EstadoCelda.VIVA; //010
				} else if (tablero.getCelda(posicion) == EstadoCelda.MUERTA && tablero.getCelda(leftNeighbor) == EstadoCelda.MUERTA && tablero.getCelda(rightNeighbor) == EstadoCelda.VIVA) {
					return EstadoCelda.VIVA; // 001
				} else if (tablero.getCelda(posicion) == EstadoCelda.MUERTA && tablero.getCelda(leftNeighbor) == EstadoCelda.MUERTA && tablero.getCelda(rightNeighbor) == EstadoCelda.MUERTA) {
					return EstadoCelda.MUERTA; 
				}

			} catch(ExcepcionPosicionFueraTablero e) {
				e.getMessage();
			}
			
		} else {
			throw new ExcepcionArgumentosIncorrectos("Tablero or Coordenada is null!");
		}
		//probleme hier?
		return null;
		
	}
	
}

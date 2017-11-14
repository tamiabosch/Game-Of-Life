package modelo;

import java.util.ArrayList;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * defines  the rules if a cell lives or not depending on the neighbours
 * @author Tami
 *
 */
public class ReglaConway extends Regla{
	
	/**
	 * empty Constructor
	 */
	public ReglaConway() {
		
	}

	/**
	 * Calculates the state of the celdas depending on it's neighbours
	 *
	 * @param tablero the tablero
	 * @param posicion the posicion
	 * @throws ExcepcionPosicionFueraTablero
	 * @return the estado celda
	 */
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		if(tablero != null && posicion != null) {

				ArrayList<Coordenada> vecinas = tablero.getPosicionesVecinasCCW(posicion);
				int aliveNeigbours = 0;

				for (Coordenada coord : vecinas) {
					if(coord != null && tablero.getCelda(coord) == EstadoCelda.VIVA) {
						aliveNeigbours++;
					}
				}
				if (tablero.getCelda(posicion) == EstadoCelda.MUERTA){
					//tote zelle wird lebendig, sofern 3 nachbarn leben
					if(aliveNeigbours == 3) {
						return EstadoCelda.VIVA;
					} else {
						return EstadoCelda.MUERTA;
					}
				} else {
					// lebende Zelle lebt mit 2 oder 3 nachbarn
					if(aliveNeigbours == 2 || aliveNeigbours == 3) {
						return EstadoCelda.VIVA;
					} 
					//jede lebende Zelle mit weniger als 2 Nachbarn stirbt
					else if (aliveNeigbours < 2) {
						return EstadoCelda.MUERTA;
					}
					// zelle mehr als 3 nachbarn -> tötung
					else {
						return EstadoCelda.MUERTA;
					}
				}
		
			
		} else {
			throw new ExcepcionArgumentosIncorrectos("Tablero or Coordenada is null!");
		}

		
	}	
		
}

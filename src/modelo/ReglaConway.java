package modelo;

import java.util.ArrayList;

public class ReglaConway {

	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion) {
		ArrayList<Coordenada> vecinas = tablero.getPosicionesVecinasCCW(posicion);
		int numberVecinas = 0;
		int aliveNeigbours = 0;
	
		for (Coordenada coord : vecinas) {
			if(coord != null) {
				numberVecinas ++;
			}
		}
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
	}	
		
}

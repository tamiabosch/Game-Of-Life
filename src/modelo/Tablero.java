package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Tablero initialises a HashMap with dead cells and gives various method to change the state of the cells  
 * @author Tamia Bosch
 */
public class Tablero {
		/**
		 * HashMap with coordenadas as key an Estado Celdas as value
		 */
		private HashMap<Coordenada, EstadoCelda> celdas;
		/**
		 * dimensiones, Coordenada from the bottom right
		 */
		private Coordenada dimensiones;
		
		/**
		 * lates coordenada of tablero which does not fit into the pattern
		 */
		private Coordenada notFittingC;
		
		/**
		 * constructor of Tablero
		 * initialises new dead celdas with hashmap
		 * @param dimensiones
		 */
		public Tablero(Coordenada dimensiones) {
			this.dimensiones = dimensiones;
			celdas = new HashMap<Coordenada, EstadoCelda>();
			for (int i = 0; i < dimensiones.getX(); i++) {
				for (int j = 0; j < dimensiones.getY(); j++) {
					Coordenada coordenada = new Coordenada(i,j);
					celdas.put(coordenada, EstadoCelda.MUERTA);
				}
			}
			
		}
		
		/**
		 * Returns all neighbours of a Coordenada in an ArrayList
		 * @param posicion
		 * @return ArrayList with neighbours
		 */
		public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) {
 			ArrayList<Coordenada> vecinas = new ArrayList<Coordenada>();
			Collection<Coordenada> keys = this.getPosiciones();
			// Sind die Dimensionen der Tablero kleiner als die Koordinate? Dann null :)
			if (posicion.getX() < 0 || posicion.getY() < 0 || dimensiones.getX() <= posicion.getX() || dimensiones.getY() <= posicion.getY()) {
				return null;
			}
			for (int i = -1; i < 2; i++ ) {
				Coordenada vecina = new Coordenada(posicion.getX()-1, posicion.getY()+i);
				for (Coordenada coordenada : keys) {
					if (vecina.equals(coordenada)) {
						vecinas.add(vecina);
		
					} 
				} 
				
			}
			Coordenada vecina01 = new Coordenada(posicion.getX(),posicion.getY()+1);
			for (Coordenada coordenada : keys) {
				if (vecina01.equals(coordenada)) {
					vecinas.add(vecina01);
	
				} 
			} 
			
			//rechte Seite
			for (int i = 1; i > -2; i-- ) {
				Coordenada vecina = new Coordenada(posicion.getX()+1, posicion.getY()+i);
				for (Coordenada coordenada : keys) {
					if (vecina.equals(coordenada)) {
						vecinas.add(vecina);
		
					} 
				} 
				
			}
			
			Coordenada vecina0_1 = new Coordenada(posicion.getX(),posicion.getY()+-1);
			for (Coordenada coordenada : keys) {
				if (vecina0_1.equals(coordenada)) {
					vecinas.add(vecina0_1);
				} 
			} 
			
            
          return vecinas;

		}
		
		/**
		 * checks if the Patron fits into the Tablero
		 * @param patron
		 * @param coordenadaInicial
		 * @return if patron fits or not
		 */
		public boolean cargaPatron(Patron patron, Coordenada coordenadaInicial) {
			boolean ok = false;
			Coordenada lastCoordenada = patron.getTablero().getDimensiones();
			int xSumaCoordenada = coordenadaInicial.suma(lastCoordenada).getX();
			int ySumaCoordenada = coordenadaInicial.suma(lastCoordenada).getY();
			int xCoordenadaDim = this.getDimensiones().getX();		//wahrscheinlich dim des juegos benutzten!!!
			int yCoordenadaDim = this.getDimensiones().getY();		//pat--tab xDimTab
			if (coordenadaInicial.getX() < 0 || coordenadaInicial.getY() < 0) {
				Coordenada cOut = coordenadaInicial;
				notFittingC = cOut;
				muestraErrorPosicionInvalida(cOut);
				return ok;
			}
			else if(xSumaCoordenada  <= xCoordenadaDim && ySumaCoordenada <= yCoordenadaDim) {
				ok = true;
				
				int startX = coordenadaInicial.getX();
				int startY = coordenadaInicial.getY();
				int endX = patron.getTablero().getDimensiones().getX() + startX;
				int endY = patron.getTablero().getDimensiones().getY() + startY;
				for(int i = startX; i < endX; i++) {
					for (int j = startY; j < endY; j++) {
						this.setCelda(new Coordenada(i, j), patron.getCelda(new Coordenada(i-startX, j-startY)));
					}
				}
				
				return ok;
			} else {
				//wenn es übers eck geht..
				Coordenada cOut = new Coordenada(lastCoordenada.getX() - xCoordenadaDim, lastCoordenada.getY() - yCoordenadaDim);
				notFittingC = coordenadaInicial;
				muestraErrorPosicionInvalida(coordenadaInicial);
				return ok;
			}
		}
		
		/**
		 * Overrides toString() method and gives back a string with a string representation of the tablero
		 */
		@Override
		public String toString() {
			String result = "";
			int sizeX = this.getDimensiones().getX();
			int sizeY = this.getDimensiones().getY();
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
			return result;
		}
		
		/**
		 * checks if the tablero contains a certain coordenada
		 * @param posicion
		 * @return boolean 
		 */
		public boolean contiene(Coordenada posicion) {
			if (celdas.get(posicion) != null) {
				return true;
			} else {
				return false;
			}
		}
		
		/**
		 * error message, specifically concerning one coordenada
		 * @param coordenada wohich doesn't fit into the board
		 */
		private void muestraErrorPosicionInvalida(Coordenada c) {
			System.err.println("Error: La celda (" + c.getX() + "," +  c.getY() + ") no existe");
		}
		
		/**
		 * returns all the Coordenadas of the Celdas
		 * @return Collection of keySet
		 */
		public Collection<Coordenada> getPosiciones() {
			return celdas.keySet();
		}
		
		/**
		 * returns if the celda is dead or alive
		 * @param posicion
		 * @return EstadoCelda
		 */
		public EstadoCelda getCelda(Coordenada posicion) {
			if (celdas.get(posicion)==null) {
				muestraErrorPosicionInvalida(posicion);
				return null;
			} else {
				return celdas.get(posicion);
			}
		}
		
		/**
		 * Getter for dimensiones
		 * @return the dimensiones
		 **/
		public Coordenada getDimensiones() {
			return dimensiones;
		}
		
		/**
		 * Getter
		 */
		public Coordenada getNotFittingC() {
			return notFittingC;

		}
		
		/**
		 * Sets posicion and status of a specific celda 
		 * @param posicion
		 * @param e
		 */
		public void setCelda(Coordenada posicion, EstadoCelda e) {
			if (celdas.get(posicion)==null) {
				muestraErrorPosicionInvalida(posicion);
			} else {
				celdas.put(posicion, e);
			}
		}
		
		
}

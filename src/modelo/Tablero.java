package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Tablero {
		private HashMap<Coordenada, EstadoCelda> celdas;
		private Coordenada dimensiones;
		
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
		 * 
		 * @param posicion
		 * @return 
		 */
		public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) {
			ArrayList<Coordenada> vecinas = new ArrayList<Coordenada>();
			Collection<Coordenada> keys = this.getPosiciones();
			for (int i = -1; i < 2; i++ ) {
				for (int j = -1; j < 2; j++) {
					if (!(i == 0 && j == 0)) {
						Coordenada vecina = new Coordenada(posicion.getX()+i, posicion.getY()+j);
						boolean found = false;
						for (Coordenada coordenada : keys) {
							if (vecina.equals(coordenada)) {
								vecinas.add(vecina);
								found = true;
							} 
						} 
						if(!found) {
							vecinas.add(null);
						}

					}
				}
			}
			return vecinas;
		}
		
		public boolean cargaPatron(Patron patron, Coordenada coordenadaInicial) {
			boolean ok = false;
			Coordenada lastCoordenada = patron.getTablero().getDimensiones();
			int xSumaCoordenada = coordenadaInicial.suma(lastCoordenada).getX();
			int ySumaCoordenada = coordenadaInicial.suma(lastCoordenada).getY();
			int xCoordenadaDim = this.getDimensiones().getX();		//wahrscheinlich dim des juegos benutzten!!!
			int yCoordenadaDim = this.getDimensiones().getY();
			if(xSumaCoordenada  <= xCoordenadaDim && ySumaCoordenada <= yCoordenadaDim) {
				ok = true;
				return ok;
			} else {
				//wenn es übers eck geht..
				Coordenada cOut = new Coordenada(xSumaCoordenada - xCoordenadaDim, ySumaCoordenada - yCoordenadaDim);
				muestraErrorPosicionInvalida(cOut);
				return ok;
			}
		}
		
		@Override
		public String toString() {
			String result = "";
			int sizeX = this.getDimensiones().getX();
			int sizeY = this.getDimensiones().getY();
			for(int i = 0; i < sizeX+2; i++) {
				for (int j = 0; i < sizeY+2; j++) {
					if (i==0 && j == 0 || i == sizeX+2 && j == 0 || i == 0 && j == sizeY+2 || i == sizeX+2 && j == sizeY+2) {
						result += "+"; 
						if (i == sizeX+2){
						result += "\n";	
						}
					} else if (j == 0 || j == sizeY+2) {
						result = "-";
					}else if (i == 0 || i == sizeX+2) {
						result = "|";
						if (i == sizeX+2) {
							result += "\n";
						}
					} else if (this.getCelda(new Coordenada(i+1,j+1)) == EstadoCelda.MUERTA) {
						result += " ";
					}else if (this.getCelda(new Coordenada(i+1,j+1)) == EstadoCelda.VIVA) {
						result += "*";
					}
				}
			}
			return result;
		}
		public boolean contiene(Coordenada posicion) {
			if (celdas.get(posicion) != null) {
				return true;
			} else {
				return false;
			}
		}
		private void muestraErrorPosicionInvalida(Coordenada c) {
			System.err.println("Error: La celda (" + c.getX() + "," +  c.getY() + "no existe");
		}
		
		/**
		 * 
		 * @return
		 */
		public Collection<Coordenada> getPosiciones() {
			return celdas.keySet();
		}
		
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
		
		public void setCelda(Coordenada posicion, EstadoCelda e) {
			if (celdas.get(posicion)==null) {
				muestraErrorPosicionInvalida(posicion);
			} else {
				celdas.put(posicion, e);
			}
		}
		
		
}

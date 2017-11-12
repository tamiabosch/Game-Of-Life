/**
 * Tablero in package modelo
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
 * Tablero initialises a HashMap with dead cells and gives various method to change the state of the cells  
 * @author Tamia Bosch
 */
public abstract class Tablero {
		/**
		 * HashMap with coordenadas as key an Estado Celdas as value
		 */
		protected HashMap<Coordenada, EstadoCelda> celdas;
		
		/**
		 * dimensiones, Coordenada from the bottom right
		 */
		protected Coordenada dimensiones;
		
		/**
		 * lates coordenada of tablero which does not fit into the pattern
		 */
		protected Coordenada notFittingC;
		
		/**
		 * constructor of Tablero
		 * initialises new dead celdas with hashmap
		 * @param dimensiones
		 * @throws ExcepcionCoordenadaIncorrecta 
		 */
		protected Tablero(Coordenada dimensiones) throws ExcepcionCoordenadaIncorrecta, ExcepcionEjecucion {
			this.dimensiones = dimensiones;
			celdas = new HashMap<Coordenada, EstadoCelda>();
			if (dimensiones instanceof Coordenada1D) {
				for (int i = 0; i < dimensiones.getX(); i++) {
					Coordenada coordenada = new Coordenada1D(i);
					celdas.put(coordenada, EstadoCelda.MUERTA);
				}
			} else {
				for (int i = 0; i < dimensiones.getX(); i++) {
					for (int j = 0; j < dimensiones.getY(); j++) {
						Coordenada coordenada;
						try {
							coordenada = new Coordenada2D(i,j);
							celdas.put(coordenada, EstadoCelda.MUERTA);
						} catch (ExcepcionCoordenadaIncorrecta e) {
							throw new ExcepcionEjecucion(e);
						}
					}
				}
			}
		}
		
		/**
		 * abstract method
		 * Returns all neighbours of a Coordenada in an ArrayList
		 * @param posicion
		 * @return ArrayList with neighbours
		 */
		public abstract ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero, ExcepcionEjecucion;

		/**
		 * checks if the Patron fits into the Tablero and adds the patron into the tablero
		 * @param patron
		 * @param coordenadaInicial
		 * @return if patron fits or not
		 * @throws ExcepcionPosicionFueraTablero 
		 * @throws ExcepcionCoordenadaIncorrecta 
		 */
		public void cargaPatron(Patron patron, Coordenada coordenadaInicial) throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos, ExcepcionEjecucion {
			if(patron != null && coordenadaInicial != null) {
					Coordenada lastCoordenada = patron.getTablero().getDimensiones();
					if (coordenadaInicial instanceof Coordenada1D) {
						int xSumaCoordenada;
						try {
							xSumaCoordenada = coordenadaInicial.suma(lastCoordenada).getX();
						} catch (ExcepcionCoordenadaIncorrecta e1) {
							throw new ExcepcionEjecucion(e1);
						}
						int xCoordenadaDim = this.getDimensiones().getX();		//wahrscheinlich dim des juegos benutzten!!!
						if (coordenadaInicial.getX() < 0) {
							Coordenada cOut = coordenadaInicial;
							throw new ExcepcionPosicionFueraTablero(this.getDimensiones(), coordenadaInicial);
						}
						else if(xSumaCoordenada  <= xCoordenadaDim) {
							int startX = coordenadaInicial.getX();
							int endX = patron.getTablero().getDimensiones().getX() + startX;
							for (int i = startX; i < endX; i++) {
								try {
									this.setCelda(new Coordenada1D(i), patron.getCelda(new Coordenada1D(i-startX)));
								}  catch (ExcepcionCoordenadaIncorrecta e) {
									throw new ExcepcionEjecucion(e);
								}
							}
							
						} else {
							//wenn es übers eck geht..
							//Coordenada cOut = new Coordenada(lastCoordenada.getX() - xCoordenadaDim, lastCoordenada.getY() - yCoordenadaDim);
							notFittingC = coordenadaInicial;
							throw new ExcepcionPosicionFueraTablero(this.getDimensiones(), coordenadaInicial);
						}
					} else {
						try {
							int xSumaCoordenada = coordenadaInicial.suma(lastCoordenada).getX();
							int ySumaCoordenada = coordenadaInicial.suma(lastCoordenada).getY();
							int xCoordenadaDim = this.getDimensiones().getX();		//wahrscheinlich dim des juegos benutzten!!!
							int yCoordenadaDim = this.getDimensiones().getY();		//pat--tab xDimTab
							if (coordenadaInicial.getX() < 0 || coordenadaInicial.getY() < 0) {
								Coordenada cOut = coordenadaInicial;
								throw new ExcepcionPosicionFueraTablero(this.getDimensiones(), coordenadaInicial);
							}
							else if(xSumaCoordenada  <= xCoordenadaDim && ySumaCoordenada <= yCoordenadaDim) {
								int startX = coordenadaInicial.getX();
								int startY = coordenadaInicial.getY();
								int endX = patron.getTablero().getDimensiones().getX() + startX;
								int endY = patron.getTablero().getDimensiones().getY() + startY;
								for(int i = startX; i < endX; i++) {
									for (int j = startY; j < endY; j++) {
										//ExcepcionCoordenadaIncorrecta wird nur hier gecatched weil es sonst nirgends nötig ist
										this.setCelda(new Coordenada2D(i, j), patron.getCelda(new Coordenada2D(i-startX, j-startY)));
									}
								}
								
							} else {
								//wenn es übers eck geht..
								//Coordenada cOut = new Coordenada(lastCoordenada.getX() - xCoordenadaDim, lastCoordenada.getY() - yCoordenadaDim);
								notFittingC = coordenadaInicial;
								throw new ExcepcionPosicionFueraTablero(this.getDimensiones(), coordenadaInicial);
							}
						} catch (ExcepcionCoordenadaIncorrecta e) {
							throw new ExcepcionEjecucion(e);
						}
					}
					
			} else {
				throw new ExcepcionArgumentosIncorrectos("Coordenada or Patron is null!");
			}
			
		}
		
		
		
		/**
		 * checks if the tablero contains a certain coordenada
		 * @param posicion
		 * @return boolean 
		 */
		public boolean contiene(Coordenada posicion) throws ExcepcionArgumentosIncorrectos{
			if(posicion != null) {
				if (celdas.get(posicion) != null) {
					return true;
				} else {	
					return false;
				}
			} else {
				throw new ExcepcionArgumentosIncorrectos("Coordenada posicion is null!");
			}
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
		 * @throws ExcepcionPosicionFueraTablero 
		 */
		public EstadoCelda getCelda(Coordenada posicion) throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos {
			if(posicion != null) {
				if(celdas.get(posicion)==null) {
					throw new ExcepcionPosicionFueraTablero(this.getDimensiones(), posicion);
				} else {
					return celdas.get(posicion);
				}
			} else {
				throw new ExcepcionArgumentosIncorrectos("Coordenada posicion is null!");
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
		 * Getter
		 */
		public HashMap<Coordenada, EstadoCelda> getCeldas() {
			return celdas;
		}
		
		/**
		 * Sets posicion and status of a specific celda 
		 * @param posicion
		 * @param e
		 * @throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero 
		 */
		public void setCelda(Coordenada posicion, EstadoCelda e) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero {
			if(posicion != null) {
				if (celdas.get(posicion)==null) {
					throw new ExcepcionPosicionFueraTablero(this.getDimensiones(), posicion);
				} else {
					celdas.put(posicion, e);
				}
			} else {
				throw new ExcepcionArgumentosIncorrectos("Coordenada posicion is null!");
			}
		}
		
		
}

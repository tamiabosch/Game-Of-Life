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
		 * @param dimensiones Cooordenada
		 */
		protected Tablero(Coordenada dimensiones) {
			this.dimensiones = dimensiones;
			celdas = new HashMap<Coordenada, EstadoCelda>();
		}
		
		/**
		 * abstract method
		 * Returns all neighbours of a Coordenada in an ArrayList
		 * @param posicion Coordenada
		 * @return ArrayList with neighbours
		 * @throws ExcepcionPosicionFueraTablero
		 */
		public abstract ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionPosicionFueraTablero;

		/**
		 * checks if the Patron fits into the Tablero and adds the patron into the tablero
		 * @param patron Patron
		 * @param coordenadaInicial Coordenada
		 * @throws ExcepcionPosicionFueraTablero 
		 */
		public void cargaPatron(Patron patron, Coordenada coordenadaInicial) throws ExcepcionPosicionFueraTablero {
			if(patron != null && coordenadaInicial != null) {
				try {
					Coordenada lastPatronCoordenada = patron.getTablero().getDimensiones().suma(coordenadaInicial);
					Collection<Coordenada> keysPatron = patron.getPosiciones();
					for(Coordenada key: keysPatron) {
						this.getCelda(key.suma(coordenadaInicial));
					}
					for(Coordenada key: keysPatron) {
						this.setCelda(key.suma(coordenadaInicial), patron.getCelda(key));
					}
					
				} catch (ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
					
			} else {
				throw new ExcepcionArgumentosIncorrectos("Coordenada or Patron is null!");
			}
			
		}
		
		
		
		/**
		 * checks if the tablero contains a certain coordenada
		 * @param posicion Coordenada
		 * @return boolean 
		 */
		public boolean contiene(Coordenada posicion) {
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
		 * @param posicion Coordenada
		 * @return EstadoCelda
		 * @throws ExcepcionPosicionFueraTablero 
		 */
		public EstadoCelda getCelda(Coordenada posicion) throws ExcepcionPosicionFueraTablero {
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
		 * @return Coordenada coordenada
		 */
		public Coordenada getNotFittingC() {
			return notFittingC;
		}
		
		/**
		 * Getter
		 * @return HashMap celdas
		 */
		public HashMap<Coordenada, EstadoCelda> getCeldas() {
			return celdas;
		}
		
		/**
		 * Sets posicion and status of a specific celda 
		 * @param posicion Coordenada
		 * @param e EstadoCelda
		 * @throws ExcepcionPosicionFueraTablero 
		 */
		public void setCelda(Coordenada posicion, EstadoCelda e) throws ExcepcionPosicionFueraTablero {
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

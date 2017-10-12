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
		private void muestraErrorPosicionInvalida(Coordenada c) {
			System.err.println("Error: La celda (" + c.getX() + "," +  c.getY() + "no existe");
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
		 * 
		 * @return
		 */
		public Collection<Coordenada> getPosiciones() {
			return celdas.keySet();
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

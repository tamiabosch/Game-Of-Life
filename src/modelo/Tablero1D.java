/**
 * 
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
 * @author Tamia Bosch
 *Tablero 1D with onedimensional coordinates
 */
public class Tablero1D extends Tablero {
	
	/**
	 * HashMap with coordenadas as key an Estado Celdas as value
	 */
	//protected HashMap<Coordenada, EstadoCelda> celdas;

	
	/**
	 * Construcotr for Tablero1D calls the constructor of Tablero
	 * @param ancho
	 * @throws ExcepcionCoordenadaIncorrecta
	 * @throws ExcepcionEjecucion
	 */
	public Tablero1D(int ancho) throws ExcepcionCoordenadaIncorrecta, ExcepcionEjecucion {
		super(new Coordenada1D(ancho));
	}


	/**
	 * getPosicionesVecinasCCW returns all neighbours in an Arraylist
	 * @param posicion
	 * @return ArrayList with neighbours
	 */
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero, ExcepcionEjecucion {
		if(posicion != null) {
			try {
	 			ArrayList<Coordenada> vecinas = new ArrayList<Coordenada>();
				Collection<Coordenada> keys = this.getPosiciones();
				// Sind die Dimensionen der Tablero kleiner als die Koordinate? Dann null :)
				if (posicion.getX() < 0 || dimensiones.getX() <= posicion.getX()) {
					return null;
				}
				
				if (posicion.getX()-1 >= 0) {
					Coordenada vecina = new Coordenada1D(posicion.getX()-1);
					vecinas.add(vecina);
				}
				
				if (posicion.getX()+1 < dimensiones.getX()) {
					Coordenada vecina = new Coordenada1D(posicion.getX()+1);
					vecinas.add(vecina);
				}
				
	          return vecinas;
	          
			} catch (ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e);
			}

		} else {
			throw new ExcepcionArgumentosIncorrectos("Coordenada posicion is null!");
		}
	}
	
	/**
	 * Overrides toString() method and gives back a string with a string representation of the tablero
	 *@return String of Cellstructure
	 */
	@Override
	public String toString() {
		try {
			String result = "";
			int sizeX = this.getDimensiones().getX();
			for (int i = 0; i <= sizeX+1; i++) {
				if (i == 0 || i == sizeX+1) {
					result += "|";
					if (i == sizeX+1) {
						result += "\n";
					}
				} else if (this.getCelda(new Coordenada1D(i-1)) == EstadoCelda.MUERTA) {
					result += " ";
				} else if (this.getCelda(new Coordenada1D(i-1)) != null && this.getCelda(new Coordenada1D(i-1)) == EstadoCelda.VIVA) {
					result += "*";
				}
			}
			return result;
			//ob das stimmt wird sich zeigen...??
		} catch(ExcepcionCoordenadaIncorrecta e) {
			throw new ExcepcionEjecucion(e);
		} catch(ExcepcionArgumentosIncorrectos e) {
			throw new ExcepcionEjecucion(e);
		} catch(ExcepcionPosicionFueraTablero e) {
			throw new ExcepcionEjecucion(e);
		}
		
	}

}

/**
 * 
 */
package modelo;

import java.util.ArrayList;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class Tablero1D.
 *
 * @author Tamia Bosch
 * Tablero 1D with onedimensional coordinates
 */
public class Tablero1D extends Tablero implements Imprimible {

	/** casting the dimensiones into a Coordenada1D. */
	private Coordenada1D dim1D;
	
	/**
	 * Constructor for Tablero1D.
	 *
	 * @param ancho int
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public Tablero1D(int ancho) throws ExcepcionCoordenadaIncorrecta {
		super(new Coordenada1D(ancho));
		this.dim1D = (Coordenada1D) dimensiones;
		for (int i = 0; i < dim1D.getX(); i++) {
			Coordenada coordenada = new Coordenada1D(i);
			celdas.put(coordenada, EstadoCelda.MUERTA);
		}
	}


	/**
	 * getPosicionesVecinasCCW returns all neighbours in an Arraylist.
	 *
	 * @param posicion Coordenada
	 * @return the posiciones vecinas CCW
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		if(posicion != null) {
			try {
				//casting the posicion
				Coordenada1D pos1D = (Coordenada1D) posicion;
	 			ArrayList<Coordenada> vecinas = new ArrayList<Coordenada>();
				//Collection<Coordenada> keys = this.getPosiciones();
				// Sind die Dimensionen der Tablero kleiner als die Koordinate? Dann null :)
				if (pos1D.getX() < 0 || dim1D.getX() <= pos1D.getX()) {
					throw new ExcepcionPosicionFueraTablero(dim1D, pos1D);
				}
				
				if (pos1D.getX()-1 >= 0) {
					Coordenada vecina = new Coordenada1D(pos1D.getX()-1);
					vecinas.add(vecina);
				}
				
				if (pos1D.getX()+1 < dim1D.getX()) {
					Coordenada vecina = new Coordenada1D(pos1D.getX()+1);
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
	 * Overrides toString() method and gives back a string with a string representation of the tablero.
	 *
	 * @return String of Cellstructure
	 */
	@Override
	public String toString() {
		try {
			String result = "";
			int sizeX = dim1D.getX();
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


	/**
	 * Method immplemented from Imprimibe 
	 */
	@Override
	public String generaCadena() {
		return toString();
	}

}

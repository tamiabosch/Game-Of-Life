package modelo;

import java.util.ArrayList;
import java.util.Collection;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class TableroCeldasCuadradas.
 * @author Tamia Bosch
 */
public class TableroCeldasCuadradas extends Tablero2D {
	
	/**
	 * Instantiates a new tablero celdas cuadradas.
	 *
	 * @param ancho the ancho
	 * @param alto the alto
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public TableroCeldasCuadradas(int ancho, int alto) throws ExcepcionCoordenadaIncorrecta {
		super(ancho, alto);
	}
	
	/**
	 * getPosicionesVecinasCCW gives back all the neighbours
	 * @param posicion
	 * @return ArrayList with neighbours
	 * @throws ExcepcionPosicionFueraTablero
	 */
	@Override
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		if(posicion != null) {
			try {
				//casting the posicion
				Coordenada2D pos2D = (Coordenada2D) posicion;
	 			ArrayList<Coordenada> vecinas = new ArrayList<Coordenada>();
				Collection<Coordenada> keys = this.getPosiciones();
				// Sind die Dimensionen der Tablero kleiner als die Koordinate? Dann null :)
				if (pos2D.getX() < 0 || pos2D.getY() < 0 || dim2D.getX() <= pos2D.getX() || dim2D.getY() <= pos2D.getY()) {
					throw new ExcepcionPosicionFueraTablero(dim2D, pos2D);
				}
				
				for (int i = -1; i < 2; i++ ) {
					if(pos2D.getX()-1 >=0 && pos2D.getY()+i >= 0) {
						Coordenada vecina = new Coordenada2D(pos2D.getX()-1, pos2D.getY()+i);
						for (Coordenada coordenada : keys) {
							if (vecina.equals(coordenada)) {
								vecinas.add(vecina);
				
							} 
						} 	
					}
				}
				
				if(pos2D.getX() >= 0 && pos2D.getY()+1 >= 0) {
					Coordenada vecina01 = new Coordenada2D(pos2D.getX(),pos2D.getY()+1);
					for (Coordenada coordenada : keys) {
						if (vecina01.equals(coordenada)) {
							vecinas.add(vecina01);
			
						} 
					}
				}

				
				//rechte Seite
				for (int i = 1; i > -2; i-- ) {
					if(pos2D.getX()+1 >= 0 && pos2D.getY()+i >= 0) {
						Coordenada vecina = new Coordenada2D(pos2D.getX()+1, pos2D.getY()+i);
						for (Coordenada coordenada : keys) {
							if (vecina.equals(coordenada)) {
								vecinas.add(vecina);
				
							} 
						} 	
					}
				}
				
				if(pos2D.getX() >= 0 && pos2D.getY()+-1 >= 0) {
					Coordenada vecina0_1 = new Coordenada2D(pos2D.getX(),pos2D.getY()+-1);
					for (Coordenada coordenada : keys) {
						if (vecina0_1.equals(coordenada)) {
							vecinas.add(vecina0_1);
						} 
					}
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
	 * @return String representation
	 */
	@Override
	public String toString() {
		try {
			String result = "";
			int sizeX = dim2D.getX();
			int sizeY = dim2D.getY();
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
					} else if (this.getCelda(new Coordenada2D(i-1,j-1)) == EstadoCelda.MUERTA) {
						result += " ";
					}else if (this.getCelda(new Coordenada2D(i-1,j-1)) == EstadoCelda.VIVA) {
						result += "*";
					}
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


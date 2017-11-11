package modelo;

import java.util.ArrayList;
import java.util.Collection;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class TableroCeldasCuadradas extends Tablero2D {
	
	public TableroCeldasCuadradas(int ancho, int alto) throws ExcepcionCoordenadaIncorrecta {
		super(ancho, alto);
	}
	
	@Override
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion)  throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero, ExcepcionEjecucion {
		if(posicion != null) {
			try {
	 			ArrayList<Coordenada> vecinas = new ArrayList<Coordenada>();
				Collection<Coordenada> keys = this.getPosiciones();
				// Sind die Dimensionen der Tablero kleiner als die Koordinate? Dann null :)
				if (posicion.getX() < 0 || posicion.getY() < 0 || dimensiones.getX() <= posicion.getX() || dimensiones.getY() <= posicion.getY()) {
					return null;
				}
				
				for (int i = -1; i < 2; i++ ) {
					if(posicion.getX()-1 >=0 && posicion.getY()+i >= 0) {
						Coordenada vecina = new Coordenada2D(posicion.getX()-1, posicion.getY()+i);
						for (Coordenada coordenada : keys) {
							if (vecina.equals(coordenada)) {
								vecinas.add(vecina);
				
							} 
						} 	
					}
				}
				
				if(posicion.getX() >= 0 && posicion.getY()+1 >= 0) {
					Coordenada vecina01 = new Coordenada2D(posicion.getX(),posicion.getY()+1);
					for (Coordenada coordenada : keys) {
						if (vecina01.equals(coordenada)) {
							vecinas.add(vecina01);
			
						} 
					}
				}

				
				//rechte Seite
				for (int i = 1; i > -2; i-- ) {
					if(posicion.getX()+1 >= 0 && posicion.getY()+i >= 0) {
						Coordenada vecina = new Coordenada2D(posicion.getX()+1, posicion.getY()+i);
						for (Coordenada coordenada : keys) {
							if (vecina.equals(coordenada)) {
								vecinas.add(vecina);
				
							} 
						} 	
					}
				}
				
				if(posicion.getX() >= 0 && posicion.getY()+-1 >= 0) {
					Coordenada vecina0_1 = new Coordenada2D(posicion.getX(),posicion.getY()+-1);
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
	 */
	@Override
	public String toString() {
		try {
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


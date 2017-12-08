package entradasalida.textoplano;

import entradasalida.IParserTablero;
import entradasalida.excepciones.ExcepcionLectura;
import modelo.Coordenada2D;
import modelo.EstadoCelda;
import modelo.Tablero;
import modelo.Tablero2D;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class ParserTablero2D implements IParserTablero{

	public ParserTablero2D() {
	}
	@Override
	public Tablero leeTablero(String cadena) throws ExcepcionLectura {
		if(cadena==null) {
			throw new ExcepcionArgumentosIncorrectos();
		} else if(!cadena.matches("[[*]* \\s*]*") || isUneven(cadena)) {
			throw new ExcepcionLectura("Failure in leeTablero 2D, cadena doesn't match the criteria");			
		} else {
			try {
				//evtl -1 auch bei meiner kollegin
				String[] lines = cadena.split("\r\n|\r|\n");
				int xDim = lines[0].length();
				//int xDim = cadena.indexOf('\n');
				int yDim = lines.length;
				
				//initializing Tablero
				Tablero tablero = new Tablero2D(xDim,yDim);
				
				for(int y = 0; y<yDim; y++) {
					for(int x = 0; x<xDim; x++) {
						if(lines[y].charAt(xDim) == '*') {
							tablero.setCelda(new Coordenada2D(x,y), EstadoCelda.VIVA);
						} else if(lines[y].charAt(xDim) == ' ') {
							tablero.setCelda(new Coordenada2D(x,y), EstadoCelda.MUERTA);
						}
					}
				}
				
			} catch (ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e);
			} catch (ExcepcionPosicionFueraTablero e) {
				throw new ExcepcionEjecucion(e);
			}

		}
		return null;
	}
	
	public boolean isUneven(String cadena) {
		//true wenn reihen nicht gleich sind
		boolean uneven = false;
		String[] lines = cadena.split("\r\n|\r|\n");
		//extract first row to test with other rows
		int firstRow = lines[0].length();
		for (String lenght : lines) {
			if(lenght.length() == firstRow) {
				uneven = false;
			} else {
				uneven = true;
			}
		} return uneven;
	}

}

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
		} else if(!cadena.matches("[[*]* \\s*]*")) {
			throw new ExcepcionLectura("Failure in leeTablero 2D, cadena doesn't match the criteria");			
		} else {
			try {
				//evtl -1 auch bei meiner kollegin
				int xDim = cadena.indexOf("\\");
				//getting the height of the tablero
				int yDim;
				int lineBreak = 0;
				for(int i = 0; i < cadena.length(); i++) {
					if(cadena.charAt(i) == 'n') {
						lineBreak++;
					}
				}
				
				if(cadena.charAt(cadena.length() - 1) == 'n') {
					yDim = lineBreak;
				} else {
					yDim = lineBreak +1;
				}
				
				Tablero tablero = new Tablero2D(xDim,yDim);
				
				int row = -1;
				int index = 0;
				for(int y = 0; y<yDim; y++) {
					row++;
					for(int x = 0; x<xDim; x++) {
						if(cadena.charAt(index) == '*') {
							tablero.setCelda(new Coordenada2D(x,y), EstadoCelda.VIVA);
						} else if(cadena.charAt(index) == ' ') {
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

}

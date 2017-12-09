package entradasalida.textoplano;

import entradasalida.IParserTablero;
import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.excepciones.ExcepcionLectura;
import modelo.Coordenada1D;
import modelo.EstadoCelda;
import modelo.Tablero;
import modelo.Tablero1D;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class ParserTablero1D.
 */
public class ParserTablero1D implements IParserTablero{

	/**
	 * Instantiates a new parser tablero 1D.
	 */
	public ParserTablero1D() {
	}
	
	/**
	 * Returns an instance of Tablero1D created from a string containing spaces for dead cells and asterisks for live cells
	 *
	 * @param cadena represents string of cells
	 * @throws ExcepcionLectura excepcion
	 */
	@Override
	public Tablero leeTablero(String cadena) throws ExcepcionLectura {
		if(cadena==null) {
			throw new ExcepcionArgumentosIncorrectos();

			//or if message is not relevant
		} else if(!cadena.matches("[[*]* \\s*]*")){
			throw new ExcepcionLectura("Failure in leeTablero 1D, cadena doesn't match the criteria");			
		} else {
			try {
				Tablero tablero = new Tablero1D(cadena.length());
				for(int i=0; i < cadena.length(); i++) {
					if(cadena.charAt(i) == '*') {
						tablero.setCelda(new Coordenada1D(i), EstadoCelda.VIVA);
					} else if(cadena.charAt(i) == ' ') {
						tablero.setCelda(new Coordenada1D(i), EstadoCelda.MUERTA);
					}
				}
				return tablero;
			} catch (ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e);
			} catch (ExcepcionPosicionFueraTablero e) {
				throw new ExcepcionEjecucion(e);
			}
		}
	}

}

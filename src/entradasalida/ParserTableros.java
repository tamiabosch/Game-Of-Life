package entradasalida;

import entradasalida.excepciones.ExcepcionLectura;
import entradasalida.textoplano.ParserTablero1D;
import entradasalida.textoplano.ParserTablero2D;
import modelo.Tablero;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

/**
 * The Class ParserTableros.
 */
public class ParserTableros {

	/**
	 * Instantiates a new parser tableros.
	 */
	public ParserTableros() {}
	
	//TODO: It also rethrows the exceptions thrown by ParserTablero1D and ParserTablero2D. ????!!!!

	/**
	 * Lee tablero.
	 *
	 * @param cadena the cadena
	 * @return the tablero
	 * @throws ExcepcionLectura the excepcion lectura
	 */
	public static Tablero leeTablero(String cadena) throws ExcepcionLectura {
		if(cadena==null) {
			throw new ExcepcionArgumentosIncorrectos("The cadena String is null");
		} else if(cadena.isEmpty()) {
			throw new ExcepcionLectura("The cadena is an empty String");
		} else {
			//check if it's an 2D or 1D Tablero
			if(cadena.contains("\n")) {
				ParserTablero2D tablero2D = new ParserTablero2D();
				return tablero2D.leeTablero(cadena);
			} else {
				ParserTablero1D tablero1D = new ParserTablero1D();
				return tablero1D.leeTablero(cadena);
			}
		}
	}
}

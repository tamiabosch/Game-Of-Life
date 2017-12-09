package entradasalida;

import entradasalida.excepciones.ExcepcionLectura;
import modelo.Tablero;

/**
 * The Interface IParserTablero.
 */
public interface IParserTablero {
	
	//TODO:darf diese excepcion sein?!??!!?

	/**
	 * Lee tablero.
	 *
	 * @param s the s
	 * @return the tablero
	 * @throws ExcepcionLectura the excepcion lectura
	 */
	public Tablero leeTablero(String s) throws ExcepcionLectura;

}

package entradasalida;


import java.io.File;

import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Juego;

/**
 * The Interface IGeneradorFichero.
 */
public interface IGeneradorFichero {

	/**
	 * Genera fichero method for interface
	 *
	 * @param file the file
	 * @param juego the juego
	 * @param iteraciones the iteraciones
	 * @throws ExcepcionGeneracion the excepcion generacion
	 */
	//beachte die imports!!! und die Excepxionescjasc
	public void generaFichero(File file, Juego juego, int iteraciones) throws ExcepcionGeneracion;
}

package entradasalida.textoplano;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Imprimible;
import modelo.Juego;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

/**
 * The Class GeneradorFicheroPlano.
 */
public class GeneradorFicheroPlano implements IGeneradorFichero{

	/**
	 * Instantiates a new generador fichero plano.
	 */
	public GeneradorFicheroPlano() {}

	
	/**
	 * Plays the game for the number of ticks indicated by the parameter iteraciones. 
	 * After each update, it writes to the file indicated in the first parameter the result of calling the method generaCadena.
	 *
	 * @param file the saved File
	 * @param juego the juego
	 * @param iteraciones int of interacion
	 * @throws ExcepcionGeneracion excepcion
	 */
	@Override
	public void generaFichero(File file, Juego juego, int iteraciones) throws ExcepcionGeneracion {
		
		if(!(juego.getTablero() instanceof Imprimible) || iteraciones < 1) {
			throw new ExcepcionGeneracion("Iteracions are not correct: " + iteraciones);
		} else if(juego == null || file == null) {
			throw new ExcepcionArgumentosIncorrectos();
		} else {
			for (int i = 0; i < iteraciones ; i++) {
				juego.actualiza();
				Imprimible tab = (Imprimible) juego.getTablero();
				String cadena  = tab.generaCadena();
				try {
					//TODO:append string to file
					PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
					pw.append(cadena);
					pw.close();
				} catch (FileNotFoundException e) {
					throw new ExcepcionGeneracion(e);
				}
			}
		}
		
	    
	}

}

package entradasalida.imagen;

import java.io.File;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import gifs.ImagenGIF;
import modelo.Coordenada1D;
import modelo.EstadoCelda;
import modelo.Juego;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class GeneradorGIFTablero1D.
 */
public class GeneradorGIFTablero1D implements IGeneradorFichero{
	
	/**
	 * Instantiates a new generador GIF tablero 1 D.
	 */
	public GeneradorGIFTablero1D() {}


	/**
	 * Generates the Gif for a 1D Tablero evolution.
	 *
	 * @param file the saved File
	 * @param juego the juego
	 * @param iteraciones int of interacion
	 * @throws ExcepcionGeneracion excepcion
	 */
	@Override
	public void generaFichero(File file, Juego juego, int iteraciones) throws ExcepcionGeneracion {
		if(file == null || juego == null) {
			throw new ExcepcionArgumentosIncorrectos();
		} else if(iteraciones < 1) {
			throw new ExcepcionGeneracion("The interaciones are not correct: " + iteraciones);
		} else {
			Coordenada1D tmp = (Coordenada1D) juego.getTablero().getDimensiones();
			int  width = tmp.getX();
			ImagenGIF gif = new ImagenGIF(width, iteraciones);
			for (int y = 0; y < iteraciones; y++) {
				for (int x = 0; x < width; x++) {
					try {
						if(juego.getTablero().getCelda(new Coordenada1D(x)) == EstadoCelda.VIVA) {
							gif.pintaCuadrado(x, y);
						}
					} catch (ExcepcionPosicionFueraTablero | ExcepcionCoordenadaIncorrecta e) {
						throw new ExcepcionEjecucion(e);
					}
				} 
				juego.actualiza();
			}
			gif.guardaFichero(file);
		}
		
	}



}

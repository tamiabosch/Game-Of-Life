package entradasalida.imagen;

import java.io.File;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import gifs.ImagenGIF;
import gifs.ImagenGIFAnimado;
import modelo.Coordenada2D;
import modelo.EstadoCelda;
import modelo.Juego;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class GeneradorGifAnimadoTablero2D.
 */
public class GeneradorGifAnimadoTablero2D implements IGeneradorFichero {

	/**
	 * Instantiates a new generador gif animado tablero 2 D.
	 */
	public GeneradorGifAnimadoTablero2D() {}
	
	/**
	 * Responsible of generating an animated GIF, which is a sequence of GIFs .
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
		} else if (iteraciones < 1) {
			throw new ExcepcionGeneracion("The interaciones are not correct: " + iteraciones);
		} else {
			ImagenGIFAnimado gifAnimado = new ImagenGIFAnimado(100);
			int width = ((Coordenada2D) juego.getTablero().getDimensiones()).getX();
			int height = ((Coordenada2D) juego.getTablero().getDimensiones()).getY();
			for (int i = 0; i < iteraciones; i++) {
				ImagenGIF fotograma = new ImagenGIF(width, height);
				for (int x = 0; x < width ; x++) {
					for (int y = 0; y < height; y++) {
						try {
							if(juego.getTablero().getCelda(new Coordenada2D(x, y)) == EstadoCelda.VIVA) {
								fotograma.pintaCuadrado(x, y);
							}
						} catch (ExcepcionPosicionFueraTablero | ExcepcionCoordenadaIncorrecta e) {
							throw new ExcepcionEjecucion(e);
						}
					}
				}
				gifAnimado.addFotograma(fotograma);
				juego.actualiza();
			}
			
			gifAnimado.guardaFichero(file);
		}
		
	}

}

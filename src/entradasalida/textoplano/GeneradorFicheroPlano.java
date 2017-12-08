package entradasalida.textoplano;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Imprimible;
import modelo.Juego;
import modelo.Tablero;
import modelo.Tablero1D;
import modelo.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

public class GeneradorFicheroPlano implements IGeneradorFichero{

	public GeneradorFicheroPlano() {}
	
	@Override
	public void generaFichero(File file, Juego juego, int iteraciones) throws ExcepcionGeneracion {
		
	  /*  for i=0 to iteraciones-1 do
	         juego.actualiza()
	         // append to the file the string obtained from
	         // generarCadena of Tablero (which must implement Imprimible)
	    endfor */
		
		if(!(juego.getTablero() instanceof Imprimible) || iteraciones < 1) {
			throw new ExcepcionGeneracion("Iteracions are not correct: " + iteraciones);
		} else if(juego == null || file == null) {
			throw new ExcepcionArgumentosIncorrectos();
		} else {
			for (int i = 0; i < iteraciones ; i++) {
				juego.actualiza();
				Tablero tab = juego.getTablero();
				if(tab instanceof TableroCeldasCuadradas) {
					String cadena2D  = ((TableroCeldasCuadradas) tab).generaCadena();
					try {
						//TODO:append string to file
						PrintWriter pw = new PrintWriter(file);
						//PrintWriter pw = new PrintWriter(new FileOutputStream(new File("persons.txt"), true /* append = true */));
					} catch (FileNotFoundException e) {
						throw new ExcepcionGeneracion();
					}
					String cadena1D  = ((Tablero1D) tab).generaCadena();
				}
			}
		}
		
	    
	}

}

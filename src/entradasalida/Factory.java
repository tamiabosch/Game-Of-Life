package entradasalida;

import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.imagen.GeneradorGIFTablero1D;
import entradasalida.imagen.GeneradorGifAnimadoTablero2D;
import entradasalida.textoplano.GeneradorFicheroPlano;
import modelo.Coordenada;
import modelo.Coordenada1D;
import modelo.Coordenada2D;
import modelo.Regla;
import modelo.Regla30;
import modelo.ReglaConway;
import modelo.Tablero;
import modelo.Tablero1D;
import modelo.Tablero2D;
import modelo.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;

public class Factory {
	
	public Factory() {}
	
	public static IGeneradorFichero creaGeneradorFichero(Tablero tablero, String extension) throws ExcepcionGeneracion {
		if(tablero == null || extension == null) {
			throw new ExcepcionArgumentosIncorrectos();
		} else if(extension.equals("txt")){
			GeneradorFicheroPlano txt = new GeneradorFicheroPlano();
			return txt;
		} else if(extension.equals("gif")) {
			if(tablero instanceof Tablero1D) {
				GeneradorGIFTablero1D gif1D = new GeneradorGIFTablero1D();
				return gif1D;
			} else if (tablero instanceof Tablero2D) {
				GeneradorGifAnimadoTablero2D gif2D = new GeneradorGifAnimadoTablero2D();
				return gif2D;
			} else {
				throw new ExcepcionEjecucion("Error in creaGeneradorFichero, tablero is not an instance of Tablero 1D or 2D");
			}
		} else {
			throw new ExcepcionGeneracion("in creaGeneradorFichero extension does not equal 'gif' or 'txt'");
		}
	}
	
	public static Regla creaRegla(Tablero tablero) {
		if(tablero == null) {
			throw new ExcepcionArgumentosIncorrectos();
		} else if (tablero instanceof Tablero1D) {
			Regla30 regla30 = new Regla30();
			return regla30;
		} else if(tablero instanceof Tablero2D) {
			ReglaConway reglaC = new ReglaConway();
			return reglaC;
		} else {
			throw new ExcepcionEjecucion("In creaRegla the type of Tablero is unkown");
		}
	}

	public static Tablero creaTablero(Coordenada dimensiones) {
		if(dimensiones == null) {
			throw new ExcepcionArgumentosIncorrectos();
		} else if(dimensiones instanceof Coordenada1D) {
			try {
				Tablero tablero = new Tablero1D(((Coordenada1D) dimensiones).getX());
				return tablero;
			} catch (ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e);
			}
		} else if (dimensiones instanceof Coordenada2D) {
			try {
				Tablero tablero = new TableroCeldasCuadradas(((Coordenada2D) dimensiones).getX(), ((Coordenada2D) dimensiones).getY());
				return tablero;
			} catch (ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e);
			}
		} else {
			throw new ExcepcionEjecucion("in creaTablero the Coordenada dimensioes doesn't match a type");
		}
	}

}

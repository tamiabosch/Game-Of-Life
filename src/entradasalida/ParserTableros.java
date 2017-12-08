package entradasalida;

import entradasalida.excepciones.ExcepcionLectura;
import entradasalida.textoplano.ParserTablero1D;
import entradasalida.textoplano.ParserTablero2D;
import modelo.Tablero;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

public class ParserTableros {

	public ParserTableros() {}
	
	public Tablero leeTablero(String cadena) throws ExcepcionLectura {
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

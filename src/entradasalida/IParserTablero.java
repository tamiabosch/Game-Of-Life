package entradasalida;

import entradasalida.excepciones.ExcepcionLectura;
import modelo.Tablero;

public interface IParserTablero {
	
	//TODO:darf diese excepcion sein?!??!!?
	public Tablero leeTablero(String s) throws ExcepcionLectura;

}

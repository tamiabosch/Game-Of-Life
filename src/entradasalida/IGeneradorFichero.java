package entradasalida;


import java.io.File;

import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Juego;

public interface IGeneradorFichero {

	//beachte die imports!!! und die Excepxionescjasc
	public void generaFichero(File file, Juego juego, int iteraciones) throws ExcepcionGeneracion;
}

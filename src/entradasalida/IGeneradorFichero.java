package entradasalida;


import java.io.File;

import modelo.Juego;

public interface IGeneradorFichero {

	//beachte die imports!!!
	public void generaFichero(File f, Juego j, int i);
}

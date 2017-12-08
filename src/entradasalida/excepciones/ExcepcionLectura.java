package entradasalida.excepciones;

public class ExcepcionLectura extends Exception {

	public ExcepcionLectura() {
		System.out.println("ExcepcionLectura");
	}
	
	public ExcepcionLectura(String s) {
		System.out.println("ExcepcionLectura:" + s);
	}
	
	public ExcepcionLectura(Throwable t) {
		System.out.println("ExcepcionLectura:" + t);
	}
}

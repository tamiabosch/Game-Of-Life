package entradasalida.excepciones;

public class ExcepcionGeneracion extends Exception {

	public ExcepcionGeneracion() {
		System.out.println("ExcepcionGeneracion");
	}
	
	public ExcepcionGeneracion(String s) {
		System.out.println("ExcepcionGeneracion: " + s);
	}
	
	public ExcepcionGeneracion(Throwable t) {
		System.out.println("ExcepcionGeneracion: " + t);
	}
}

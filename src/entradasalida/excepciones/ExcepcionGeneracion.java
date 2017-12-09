package entradasalida.excepciones;

/**
 * The Class ExcepcionGeneracion.
 */
public class ExcepcionGeneracion extends Exception {

	/**
	 * Instantiates a new excepcion generacion.
	 */
	public ExcepcionGeneracion() {
		System.out.println("ExcepcionGeneracion");
	}
	
	/**
	 * Instantiates a new excepcion generacion.
	 *
	 * @param s the s
	 */
	public ExcepcionGeneracion(String s) {
		System.out.println("ExcepcionGeneracion: " + s);
	}
	
	/**
	 * Instantiates a new excepcion generacion.
	 *
	 * @param t the t
	 */
	public ExcepcionGeneracion(Throwable t) {
		System.out.println("ExcepcionGeneracion: " + t);
	}
}

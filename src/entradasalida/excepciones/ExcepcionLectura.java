package entradasalida.excepciones;

/**
 * The Class ExcepcionLectura.
 */
public class ExcepcionLectura extends Exception {

	/**
	 * Instantiates a new excepcion lectura.
	 */
	public ExcepcionLectura() {
		System.out.println("ExcepcionLectura");
	}
	
	/**
	 * Instantiates a new excepcion lectura.
	 *
	 * @param s the s
	 */
	public ExcepcionLectura(String s) {
		System.out.println("ExcepcionLectura:" + s);
	}
	
	/**
	 * Instantiates a new excepcion lectura.
	 *
	 * @param t the t
	 */
	public ExcepcionLectura(Throwable t) {
		System.out.println("ExcepcionLectura:" + t);
	}
}

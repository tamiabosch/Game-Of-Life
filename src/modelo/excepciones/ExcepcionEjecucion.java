/**
 * package from excepcion under modelo
 */
package modelo.excepciones;

/**
 * The Class ExcepcionEjecucion.
 *
 * @author Tami
 */
public class ExcepcionEjecucion extends RuntimeException {
	
	/**
	 * Instantiates a new excepcion ejecucion.
	 * @param mensaje type String
	 */
	public ExcepcionEjecucion(String mensaje) {
		System.out.println(mensaje + " was los string?");
	}
	
	/**
	 * Instantiates a new excepcion ejecucion.
	 * @param causa from Thorwable
	 */
	public ExcepcionEjecucion(Throwable causa) {
		causa.getMessage();
		System.out.println(causa + " was los causa?");
	}
}

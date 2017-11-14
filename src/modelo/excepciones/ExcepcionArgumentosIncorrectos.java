/**
 * 
 */
package modelo.excepciones;

/**
 * @author Tami
 *
 */
public class ExcepcionArgumentosIncorrectos extends ExcepcionEjecucion {

	/**
	 * Instantiates a new excepcion argumentos incorrectos.
	 */
	public ExcepcionArgumentosIncorrectos() {
		super("leerer Konstruktor");
	}
	
	/**
	 * Instantiates a new excepcion argumentos incorrectos.
	 *
	 * @param mensaje the mensaje
	 */
	public ExcepcionArgumentosIncorrectos(String mensaje) {
		super(mensaje);
	}
	
	/**
	 * Instantiates a new excepcion argumentos incorrectos.
	 *
	 * @param causa the causa
	 */
	public ExcepcionArgumentosIncorrectos(Throwable causa) {
		super(causa);		
	}
	
	/**
	 * Prints out an Error Message
	 * @return String message
	 */
	public String getMessage() {
		return "ExcepcionArgumentosIncorrectos";
	}
	
}

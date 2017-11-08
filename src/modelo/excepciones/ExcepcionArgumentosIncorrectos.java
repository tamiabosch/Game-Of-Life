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
	
	//maybe noch ein leerer konstruktor wegen dem UML
}

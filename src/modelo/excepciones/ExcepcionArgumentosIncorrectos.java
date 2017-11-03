/**
 * 
 */
package modelo.excepciones;

/**
 * @author Tami
 *
 */
public class ExcepcionArgumentosIncorrectos extends ExcepcionEjecucion {

	public ExcepcionArgumentosIncorrectos(String mensaje) {
		super(mensaje);
	}
	
	public ExcepcionArgumentosIncorrectos(Throwable causa) {
		super(causa);		
	}
	
	//maybe noch ein leerer konstruktor wegen dem UML
}

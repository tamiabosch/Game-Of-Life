/**
 * 
 */
package modelo.excepciones;

/**
 * @author Tami
 *
 */
public class ExcepcionCoordenada1DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	private int x;
	
	public ExcepcionCoordenada1DIncorrecta(int x) {
		this.x = x;
	}
	
	public String getMessage() {
		return "ExcepcionCoordenada1DIncorrecta: getMessage()";
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	
}

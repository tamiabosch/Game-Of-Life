/**
 * package in modelo
 */
package modelo.excepciones;

/**
 * @author Tami
 *
 */
public class ExcepcionCoordenada1DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	
	/** The x variable */
	private int x;
	
	/**
	 * Instantiates a new excepcion coordenada 1 D incorrecta.
	 * Constructor for ExcepcionCoordenada1DIncorrecta
	 *
	 * @param x is an int
	 */
	public ExcepcionCoordenada1DIncorrecta(int x) {
		this.x = x;
	}
	
	/**
	 * Prints out an Error Message
	 */
	public String getMessage() {
		return "ExcepcionCoordenada1DIncorrecta: " + x;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	
}

/**
 * 
 */
package modelo.excepciones;

/**
 * The Class ExcepcionCoordenada2DIncorrecta.
 *
 * @author Tamia Bosch
 */
public class ExcepcionCoordenada2DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	
	/** The x. */
	private int x;
	
	/** The y. */
	private int y;

	/**
	 * Instantiates a new excepcion coodenada 2 D incorrecta.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public ExcepcionCoordenada2DIncorrecta(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * returns String ErrorMessage.
	 *
	 * @return String message
	 */
	public String getMessage() {
		return"Error in ExcepcionCoodenada2DIncorrecta: x="+x+" y="+y;
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
}

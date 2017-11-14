/**
 * 
 */
package modelo.excepciones;

/**
 * @author Tami
 *
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
	 * returns String ErrorMessage
	 * @return String message
	 */
	public String getMessage() {
		return"Error in ExcepcionCoodenada2DIncorrecta: x="+x+" y="+y;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
}

/**
 * 
 */
package modelo.excepciones;

/**
 * @author Tami
 *
 */
public class ExcepcionCoodenada2DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	private int x;
	private int y;

	public ExcepcionCoodenada2DIncorrecta(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//TODO:gscheider text
	public String getMessage() {
		return"Error in: ExcepcionCoodenada2DIncorrecta";
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

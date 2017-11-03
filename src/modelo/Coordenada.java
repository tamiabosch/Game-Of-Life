/**
 * Coordenada is a part of the model and therefor in the modelo package
 */
package modelo;

import jdk.jfr.events.ExceptionThrownEvent;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * Coordenada creates a coordinate with x and y value
 * it also counts the created Coordenadas with NUMERO_COORDENADAS
 * @author Tamia Bosch
 */
public class Coordenada {
    /**
     * private instancevariable x
     */
    private int x;
    /**
     * private instancevariable y
     */
    private int y;
    /**
     * private and static instancevariable already initalized
     */
    private static int NUMERO_COORDENADAS = 0;

    /**
     * Constructor for Coordenada using an x and y coordinate
     * NUMERO_COORDENADAS is increased
     * @param x int coordinate
     * @param y int coordinate
     * @throws ExcepcionCoordenadaIncorrecta 
     */
    public Coordenada(int x, int y) throws ExcepcionCoordenadaIncorrecta {
    	if(x >= 0 || y >= 0) {
            this.x = x;
            this.y = y;
            NUMERO_COORDENADAS++;
    	} else {
    		throw new ExcepcionCoordenadaIncorrecta();
    	}

    }

    /**
     * Constructor for Coordenada copying an other coordenate
     * NUMERO_COORDENADAS is increased
     * @param otra Coordenada
     * @throws ExcepcionCoordenadaIncorrecta 
     */
    public Coordenada(Coordenada otra) throws ExcepcionArgumentosIncorrectos  {
    	if(otra!=null) {
            this.x = otra.getX();
            this.y = otra.getY();
            NUMERO_COORDENADAS++;
    	} else {
    		throw new ExcepcionArgumentosIncorrectos ("Wrong Argument: Failed initializing a Coordenada");
    	}

    }

    /**
     * Getter for NUMERO_COORDENADAS
     * @return int NUMERO_COORDENADAS
     */
    public static int getNumeroCoordenadas() {
        return NUMERO_COORDENADAS;
    }

    /**
     * Returns the coordinates as a String
     * @return String coordinate
     */
    @Override
    public String toString() {
        String concatenacion = "(" + this.x + "," + this.y + ")";
        return concatenacion;
    }

    /**
     * overrides the equals method and compares two Objects to eachother
     * @param otro an Object which gets compared
     * @return boolean if it's the same Object or not
     */
    @Override
    public boolean equals(Object otro) {
        if (this == otro) return true;
        if (otro == null || getClass() != otro.getClass()) return false;

        Coordenada that = (Coordenada) otro;

        if (x != that.x) return false;
        return y == that.y;
    }
    
	/**
	 * Overrides hashCode() method and gives back an int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

    
    /**
     * getter for x coordinate
     * @return int x
     */
    public int getX() {
        return x;
    }

	/**
     * getter for y coordinate
     * @return int y
     */
    public int getY() {
        return y;
    }

    /**
     * Is summarising the x and y values of two Coordenada Objects
     * @param otra Coordenada
     * @return new Coordenada
     * @throws ExcepcionCoordenadaIncorrecta 
     */
    public Coordenada suma(Coordenada otra) throws ExcepcionArgumentosIncorrectos {
    	if (otra == null) {
    		throw new ExcepcionArgumentosIncorrectos("Wrong Argument: the suma method couldn't be excecuted because the Coordenada was null");
    	}
    	try {
    		return new Coordenada(this.x + otra.getX(), this.y + otra.getY());
    	} catch (ExcepcionCoordenadaIncorrecta e) {
    		e.printStackTrace();
    		return null;
    	}
    }
}

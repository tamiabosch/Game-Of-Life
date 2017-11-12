/**
 * Coordenada is a part of the model and therefor in the modelo package
 */
package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenada2DIncorrecta;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * Coordenada creates a coordinate with x and y value
 * @author Tamia Bosch
 */
public class Coordenada2D extends Coordenada {
    /**
     * private instancevariable x
     */
    private int x;
    /**
     * private instancevariable y
     */
    private int y;
  
    /**
     * Constructor for Coordenada using an x and y coordinate
     * @param x int coordinate
     * @param y int coordinate
     * @throws ExcepcionCoordenada2DIncorrecta 
     */
    public Coordenada2D(int x, int y) throws ExcepcionCoordenadaIncorrecta  {
    	if(x >= 0 && y >= 0) {
            this.x = x;
            this.y = y;
    	} else {
    		throw new ExcepcionCoordenada2DIncorrecta(x,y);
    	}

    }

    /**
     * Constructor for Coordenada copying an other coordenate
     * @param otra Coordenada
     */
    public Coordenada2D(Coordenada2D otra) {
    	if(otra!=null) {
            this.x = otra.getX();
            this.y = otra.getY();
    	} else {
    		throw new ExcepcionArgumentosIncorrectos ("Wrong Argument: Failed initializing a Coordenada");
    	}

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

        Coordenada2D that = (Coordenada2D) otro;

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
     * @return new Coordenada2D
     * @throws ExcepcionCoordenadaIncorrecta
     */
    @Override
    public Coordenada2D suma(Coordenada otra) throws ExcepcionCoordenadaIncorrecta {
    	Coordenada2D castedOtra = (Coordenada2D) otra;
    	if (otra == null) {
    		throw new ExcepcionArgumentosIncorrectos("Wrong Argument: the suma method couldn't be excecuted because the Coordenada was null");
    	}
    	try {
    		return new Coordenada2D(this.x + castedOtra.getX(), this.y + castedOtra.getY());
    	} catch (ExcepcionCoordenadaIncorrecta e) {
    		e.getMessage();
    		return null;
    	}
    }
}

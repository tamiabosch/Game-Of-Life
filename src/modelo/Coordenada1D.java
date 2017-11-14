package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenada1DIncorrecta;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * The Class Coordenada1D.
 * @author Tamia Bosch
 */
public class Coordenada1D extends Coordenada{
    /**
     * private instancevariable x
     */
    private int x;
  
    /**
     * Constructor for Coordenada using an x and y coordinate
     * @param x int coordinate
     * @throws ExcepcionCoordenadaIncorrecta 
     */
    public Coordenada1D(int x) throws ExcepcionCoordenadaIncorrecta {
    	if(x >= 0) {
            this.x = x;
    	} else {
    		throw new ExcepcionCoordenada1DIncorrecta(x);
    	}
    }

    /**
     * Constructor for Coordenada copying an other coordenate
     * @param otra Coordenada
     */
    public Coordenada1D(Coordenada1D otra) {
    	if(otra!=null) {
            this.x = otra.getX();
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
        String concatenacion = "(" + this.x + ")";
        return concatenacion;
    }

    
    /**
     * hashCode Method
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
	}

	/**
	 * equals method
	 */
	@Override
	public boolean equals(Object otro) {
		if (this == otro)
			return true;
		if (otro == null)
			return false;
		if (getClass() != otro.getClass())
			return false;
		Coordenada1D other = (Coordenada1D) otro;
		if (x != other.x)
			return false;
		return true;
	}

	/**
     * getter for x coordinate
     * @return int x
     */
    public int getX() {
        return x;
    }

    /**
     * Summarises two coordinates
     * @param otra
     * @return
     * @throws ExcepcionCoordenadaIncorrecta
     */
    @Override
    public Coordenada1D suma(Coordenada otra) throws ExcepcionCoordenadaIncorrecta {
    	Coordenada1D castedOtra = (Coordenada1D) otra;
    	if (otra == null) {
    		throw new ExcepcionArgumentosIncorrectos("Wrong Argument: the suma method couldn't be excecuted because the Coordenada was null");
    	}
    	try {
    		return new Coordenada1D(this.x + castedOtra.getX());
    	} catch (ExcepcionCoordenadaIncorrecta e) {
    		e.getMessage();
    		return null;
    	}
    }
    
}

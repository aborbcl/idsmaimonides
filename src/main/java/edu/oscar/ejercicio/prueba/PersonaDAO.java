package edu.oscar.ejercicio.prueba;

import java.sql.SQLException;
import java.util.Collection;

public interface PersonaDAO {
	 public abstract boolean alta(Persona persona)
		        throws SQLException;

		    public abstract boolean baj(Persona persona)
		        throws SQLException;

		    public abstract boolean modif(Persona persona)
		        throws SQLException;

		    public abstract Collection lista()
		        throws SQLException;

}

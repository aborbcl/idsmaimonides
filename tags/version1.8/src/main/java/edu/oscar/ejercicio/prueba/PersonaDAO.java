package edu.oscar.ejercicio.prueba;

import java.sql.SQLException;
import java.util.Collection;

public interface PersonaDAO{
	public abstract boolean crear(Persona persona)
	        throws SQLException;

	    public abstract boolean borrar(Persona persona)
	        throws SQLException;

	    public abstract boolean guardar(Persona persona)
	        throws SQLException;

	    public abstract Collection listar()
	        throws SQLException;
}

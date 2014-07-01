package edu.oscar.ejercicio.prueba;

import java.sql.Connection;
import java.sql.SQLException;

import org.hsqldb.Statement;

public class ModeloDB {
	 public ModeloDB()
	    {
	    }

	    public boolean createModel(Connection conn)
	        throws SQLException
	    {
	        Statement stmt = conn.createStatement();
	        stmt.executeUpdate("CREATE TABLE Personas(dni int, nombre varchar(100),apellido varchar(100))");
	        return true;
	    }

}

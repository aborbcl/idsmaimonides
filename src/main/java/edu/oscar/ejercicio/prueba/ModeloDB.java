package edu.oscar.ejercicio.prueba;

import java.sql.Connection;
import java.sql.SQLException;

public class ModeloDB {
	 public ModeloDB()
	    {
	    }

	    public boolean createModel(Connection conn)
	        throws SQLException
	    {
	        java.sql.Statement stmt = conn.createStatement();
	        stmt.executeUpdate("CREATE TABLE Personas(dni int, nombre varchar(100),apellido varchar(100))");
	        return true;
	    }
	    public boolean borrarTabla(Connection conn)
		        throws SQLException
		    {
		        java.sql.Statement stmt = conn.createStatement();
		        stmt.executeUpdate("DROP TABLE Personas");
		        return true;
		    }

}

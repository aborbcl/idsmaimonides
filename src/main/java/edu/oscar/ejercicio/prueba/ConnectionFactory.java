package edu.oscar.ejercicio.prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	 public ConnectionFactory()
	    {
	    }

	    public Connection createConn(String URL)
	        throws SQLException
	    {
	        Connection conexion = null;
	        conexion = DriverManager.getConnection(URL, "OS", "");
	        return conexion;
	    }
}
